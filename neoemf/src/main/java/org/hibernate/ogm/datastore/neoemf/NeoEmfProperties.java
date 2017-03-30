package org.hibernate.ogm.datastore.neoemf;

import org.hibernate.ogm.datastore.document.cfg.DocumentStoreProperties;

public class NeoEmfProperties implements DocumentStoreProperties {
	
	
	/**
     * The backend to use
     *
     */
	public static final String BACKEND = "hibernate.ogm.neoemf.backend";
	
	/**
     * URI of the backend data store.
     *
     */
	public static final String BACKEND_URI = "hibernate.ogm.neoemf.backend_uri";
	
	/**
     * Caches the presence of a value.
     *
     * @see fr.inria.atlanmod.neoemf.data.store.IsSetCachingStoreDecorator
     */
	public static final String CACHE_IS_SET = "hibernate.ogm.neoemf.is_set_caching";
	
    /**
     * Caches the size data.
     *
     * @see fr.inria.atlanmod.neoemf.data.store.SizeCachingStoreDecorator
     */
	public static final String CACHE_SIZE = "hibernate.ogm.neoemf.size_caching";
	
    /**
     * Caches {@link EStructuralFeature}.
     *
     * @see fr.inria.atlanmod.neoemf.data.store.FeatureCachingStoreDecorator
     */
	public static final String CACHE_STRUCTURAL_FEATURE = "hibernate.ogm.neoemf.feature_caching";
	
    /**
     * Logs every call to a methods.
     *
     * @see fr.inria.atlanmod.neoemf.data.store.LoggingStoreDecorator
     */
	public static final String LOG = "hibernate.ogm.neoemf.logging";
	
    /**
     * Counts all loaded objects.
     *
     * @see fr.inria.atlanmod.neoemf.data.store.LoadedObjectCounterStoreDecorator
     */
	public static final String COUNT_LOADED_OBJECT = "hibernate.ogm.neoemf.loaded_object_counter";
	
	/**
     * Automatically saves modifications as calls are made.
     * 
     * @see fr.inria.atlanmod.neoemf.data.store.AutocommitStoreDecorator
     */
	public static final String AUTOCOMMIT = "hibernate.ogm.neoemf.blueprints.autocommit";
	
    /**
     * Translate model-level operations into datastore calls.
     * 
     * @see fr.inria.atlanmod.neoemf.data.store.DirectWriteStore;
     */
	public static final String DIRECT_WRITE = "hibernate.ogm.neoemf.blueprints.direct_write";
	
    /**
     * Use an internal cache to store {@link Vertex} elements that are part of multi-valued {@link EReference}s to
     * speed-up their access.
     * 
     * @ see fr.inria.atlanmod.neoemf.data.blueprints.store.DirectWriteBlueprintsCacheManyStore
     */
	public static final String CACHE_MANY = "hibernate.ogm.neoemf.blueprints.cache_many";
	
	//FIXME Add options for the remaining backends!

}
