/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.mongodb.test.query.parsing.nativequery;

import static org.fest.assertions.Assertions.assertThat;

import org.hibernate.ogm.datastore.mongodb.query.impl.MongoDBQueryDescriptor;
import org.hibernate.ogm.datastore.mongodb.query.impl.MongoDBQueryDescriptor.Operation;
import org.hibernate.ogm.datastore.mongodb.query.parsing.nativequery.impl.MongoDBQueryDescriptorBuilder;
import org.hibernate.ogm.datastore.mongodb.query.parsing.nativequery.impl.NativeQueryParser;
import org.hibernate.ogm.utils.TestForIssue;
import org.junit.Test;
import org.parboiled.Parboiled;
import org.parboiled.parserunners.RecoveringParseRunner;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

import com.mongodb.BasicDBObject;
import com.mongodb.util.JSON;

/**
 * Unit test for {@link NativeQueryParser}.
 *
 * @author Gunnar Morling
 */
public class NativeQueryParserTest {

	@Test
	@TestForIssue(jiraKey = "OGM-1024")
	public void shouldParseSimplifiedAggregateQuery() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		String match = "{ '$match': {'author' : 'Oscar Wilde' } }";
		String sort = "{ '$sort': {'name' : -1 } }";
		ParsingResult<MongoDBQueryDescriptorBuilder> run = new ReportingParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.aggregate([" + match + ", " + sort + " ])" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.AGGREGATE_PIPELINE );
		assertThat( queryDescriptor.getPipeline() )
			.containsExactly(
					JSON.parse( match ),
					JSON.parse( sort )
					);
	}

	@Test
	@TestForIssue(jiraKey = "OGM-1024")
	public void shouldParseComplexAggregateQuery() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		String match = "{ '$match': { 'NAME':{'$regex':'Bangalore', '$options': 'i'}}}";
		String unwind = "{'$unwind': '$clicks'}";
		String group = "{ '$group': {'_id' : '$_id' ,'clicks' : {'$push':'$clicks'} ,'token' : { '$push': '$TOKEN' } } }";
		String sort = "{ '$sort': { '_id' : -1 } }";
		String nativeQuery = "db.UserFactualContent.aggregate(["
						+ match
						+ "," + unwind
						+ "," + group
						+ "," + sort
						+ "])";
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new ReportingParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() ).run( nativeQuery );

		System.out.println( ParseTreeUtils.printNodeTree( run ) );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "UserFactualContent" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.AGGREGATE_PIPELINE );
		assertThat( queryDescriptor.getPipeline() )
			.containsExactly(
					JSON.parse( match )
					, JSON.parse( unwind )
					, JSON.parse( group )
					, JSON.parse( sort )
					);
	}

	@Test
	@TestForIssue(jiraKey = "OGM-1247")
	public void shouldParseDistinctQueryWithFieldOnly() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run = new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.distinct('item')" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.DISTINCT );
		assertThat( queryDescriptor.getCriteria() ).isNull();
		assertThat( queryDescriptor.getCollation() ).isNull();
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
		assertThat( queryDescriptor.getDistinctFieldName() ).isEqualTo( "item" );
	}

	@Test
	@TestForIssue(jiraKey = "OGM-1247")
	public void shouldParseDistinctQueryWithCriteriaAndCollation() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run = new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.distinct('item',{'orderId': { '$in': ['XYZ123', '123']}},{'collation' : {'locale' : 'fr'}})" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.DISTINCT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ 'orderId' : { '$in': ['XYZ123', '123']}}" ) );
		assertThat( queryDescriptor.getCollation().getLocale() ).isEqualTo( "fr" );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
		assertThat( queryDescriptor.getDistinctFieldName() ).isEqualTo( "item" );
	}

	@Test
	@TestForIssue(jiraKey = "OGM-1247")
	public void shouldParseDistinctQueryWithCollationOnly() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.distinct('item', {}, {'collation' : {'locale' : 'fr'}})" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.DISTINCT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{}" ) );
		assertThat( queryDescriptor.getCollation().getLocale() ).isEqualTo( "fr" );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
		assertThat( queryDescriptor.getDistinctFieldName() ).isEqualTo( "item" );
	}

	@Test
	public void shouldParseSimplifiedFindQuery() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "{ \"foo\" : true }" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isNull();
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseSimpleQuery() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find({\"foo\":true})" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseSimpleQueryUsingSingleQuotes() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { 'foo' : true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryWithEmptyFind() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find({})" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( new BasicDBObject() );
	}

	@Test
	public void shouldParseQueryInsertSingleDocument() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.insert( { 'item': 'card', 'qty': 15 } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.INSERT );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse( "{ 'item': 'card', 'qty': 15 }" ) );
	}

	@Test
	public void shouldParseQueryInsertSingleDocumentAndOptions() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.insert( { 'item': 'card', 'qty': 15 }, { 'ordered': true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.INSERT );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse( "{ 'item': 'card', 'qty': 15 }" ) );
		assertThat( queryDescriptor.getOptions() ).isEqualTo( JSON.parse( "{ ordered: true })" ) );
	}

	@Test
	public void shouldParseQueryInsertMultipleDocuments() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.insert( [ { '_id': 11, 'item': 'pencil', 'qty': 50, 'type': 'no.2' }, { 'item': 'pen', 'qty': 20 }, { 'item': 'eraser', 'qty': 25 } ] )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.INSERT );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse(
				"[ { '_id': 11, 'item': 'pencil', 'qty': 50, 'type': 'no.2' }, { 'item': 'pen', 'qty': 20 }, { 'item': 'eraser', 'qty': 25 } ]" ) );
	}

	@Test
	public void shouldParseQueryInsertMultipleDocumentsAndOptions() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.insert( [ { '_id': 11, 'item': 'pencil', 'qty': 50, 'type': 'no.2' }, { 'item': 'pen', 'qty': 20 }, { 'item': 'eraser', 'qty': 25 } ], { 'ordered': true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.INSERT );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse(
				"[ { '_id': 11, 'item': 'pencil', 'qty': 50, 'type': 'no.2' }, { 'item': 'pen', 'qty': 20 }, { 'item': 'eraser', 'qty': 25 } ]" ) );
		assertThat( queryDescriptor.getOptions() ).isEqualTo( JSON.parse( "{ ordered: true })" ) );
	}

	@Test
	public void shouldParseQueryWithEmptyRemove() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.remove( 	{\n 	}\n 	)" ); // Include superfluous whitespace.

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.REMOVE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( new BasicDBObject() );
	}

	@Test
	public void shouldParseQueryWithEmptyRemoveAndOptionalJustOne() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.remove({},true)" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.REMOVE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( new BasicDBObject() );
		assertThat( queryDescriptor.getOptions() ).isEqualTo( JSON.parse( "{ \"justOne\" : true }" ) );
	}

	@Test
	public void shouldParseQueryWithEmptyRemoveAndOptions() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.remove( { }, { 'justOne': true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.REMOVE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( new BasicDBObject() );
		assertThat( queryDescriptor.getOptions() ).isEqualTo( JSON.parse( "{ \"justOne\" : true }" ) );
	}

	@Test
	public void shouldParseQueryUpdate() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.update( { 'name': 'Andy' }, { 'rating': 1, 'score': 1 } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.UPDATE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ 'name': 'Andy' }" ) );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse( "{ 'rating': 1, 'score': 1 }" ) );
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryUpdateWithOptions() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.update( { 'name': 'Andy' }, { 'rating': 1, 'score': 1 }, { 'upsert': true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.UPDATE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ 'name': 'Andy' }" ) );
		assertThat( queryDescriptor.getUpdateOrInsert() ).isEqualTo( JSON.parse( "{ 'rating': 1, 'score': 1 }" ) );
		assertThat( queryDescriptor.getOptions() ).isEqualTo( JSON.parse( "{ 'upsert': true }" ) );
	}

	@Test
	public void shouldParseQueryFindAndModify() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.findAndModify( { 'query': { 'name': 'Andy' }, 'sort': { 'rating': 1 }, 'update': { '$inc': { 'score': 1 } }, 'upsert': true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FINDANDMODIFY );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse(
				"{ 'query': { 'name': 'Andy' }, 'sort': { 'rating': 1 }, 'update': { '$inc': { 'score': 1 } }, 'upsert': true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryFindOneWithoutCriteriaNorProjection() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.findOne(  )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FINDONE );
		assertThat( queryDescriptor.getCriteria() ).isNull();
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryFindOneWithoutProjection() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.findOne( { \"foo\" : true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FINDONE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryFindOneWithCriteriaAndProjection() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.findOne( { \"foo\" : true }, { \"foo\" : 1 } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FINDONE );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isEqualTo( JSON.parse( "{ \"foo\" : 1 }" ) );
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryWithProjection() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { \"foo\" : true }, { \"foo\" : 1 } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isEqualTo( JSON.parse( "{ \"foo\" : 1 }" ) );
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryWithWhitespace() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "  db  .  Order  .  find  (  {  \"  foo  \"  :  true  }  ,  {  \"foo\"  :  1  }  )  " );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();
		assertThat( run.hasErrors() ).isFalse();
		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"  foo  \" : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isEqualTo( JSON.parse( "{ \"foo\" : 1 }" ) );
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseQueryWithSeveralConditions() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ReportingParseRunner<MongoDBQueryDescriptorBuilder> runner = new ReportingParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  runner
				.run( "db.Order.find( { \"foo\" : true, \"bar\" : 42, \"baz\" : \"qux\" } )" );

		assertThat( run.hasErrors() ).isFalse();
		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ \"foo\" : true, \"bar\" : 42, \"baz\" : \"qux\" }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQuery() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count()" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isNull();
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQueryWithCriteria() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count( { 'foo' : true } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ 'foo' : true }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQueryWithLogicalOperatorOR() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count( { '$or': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$or': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQueryWithLogicalOperatorAND() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count( { '$and': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$and': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQueryWithLogicalOperatorNOR() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count( { '$nor': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$nor': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseCountQueryWithLogicalOperatorNOT() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.count( { '$not': { 'foo' : false } } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$not': { 'foo' : false } } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseFindQueryWithLogicalOperatorOR() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { '$or': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$or': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldParseFindQueryWithLogicalOperatorAND() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { '$and': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$and': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldFindCountQueryWithLogicalOperatorNOR() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { '$nor': [ { 'foo' : true }, { 'bar' : '42' } ] } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$nor': [ { 'foo' : true }, { 'bar' : '42' } ] } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	public void shouldFindeCountQueryWithLogicalOperatorNOT() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.Order.find( { '$not': { 'foo' : false } } )" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "Order" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.FIND );
		assertThat( queryDescriptor.getCriteria() ).isEqualTo( JSON.parse( "{ '$not': { 'foo' : false } } }" ) );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}

	@Test
	@TestForIssue(jiraKey = "OGM-900")
	public void shouldSupportDotInCollectionName() {
		NativeQueryParser parser = Parboiled.createParser( NativeQueryParser.class );
		ParsingResult<MongoDBQueryDescriptorBuilder> run =  new RecoveringParseRunner<MongoDBQueryDescriptorBuilder>( parser.Query() )
				.run( "db.POEM.COM.count()" );

		MongoDBQueryDescriptor queryDescriptor = run.resultValue.build();

		assertThat( queryDescriptor.getCollectionName() ).isEqualTo( "POEM.COM" );
		assertThat( queryDescriptor.getOperation() ).isEqualTo( Operation.COUNT );
		assertThat( queryDescriptor.getProjection() ).isNull();
		assertThat( queryDescriptor.getOrderBy() ).isNull();
	}


}
