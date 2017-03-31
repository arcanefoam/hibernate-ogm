/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.datastore.neoemf.logging.impl;

import static org.jboss.logging.Logger.Level.INFO;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * Log message abstraction for i18n.
 *
 * @author Horacio Hoyos
 */
@MessageLogger(projectCode = "OGM")
public interface Log extends org.hibernate.ogm.util.impl.Log {
	
	// for neoemf backend use uniq ids up from 4701...
	
	@LogMessage(level = INFO)
	@Message(id = 4701, value = "Connecting to NeoEmf at %1$s")
	void connectingToCassandra(String uri);

	@Message(id = 4702, value = "Unable to load the resource.")
	HibernateException unableToLoadResource(@Cause Exception e);
	
	@Message(id = 4703, value = "Unable to save the resource")
	HibernateException unableToSaveResource(@Cause Exception e);

	
}
