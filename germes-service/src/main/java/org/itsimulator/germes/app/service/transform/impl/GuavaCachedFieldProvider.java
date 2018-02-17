package org.itsimulator.germes.app.service.transform.impl;

import java.util.List;

import org.itsimulator.germes.app.infra.util.ReflectionUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

/**
 * This implementation is similar to CachedFieldProvider 
 * but uses Google Guava collections instead of Java collections 
 * @author Sergey Morenets
 *
 */
public class GuavaCachedFieldProvider extends FieldProvider{
	/**
	 * Mapping between transformation pair(class names) and field list
	 */
	private final ListMultimap<String, String> cache;
	
	public GuavaCachedFieldProvider() {
		cache = ArrayListMultimap.create();	
	}
	
	/**
	 * Returns list of similar field names for source/destination classes
	 * @param source
	 * @param dest
	 * @return
	 */
	@Override
	public List<String> getFieldNames(Class<?> source, Class<?> dest) {
		String key = source.getSimpleName() + dest.getSimpleName();
		
		List<String> fields = cache.get(key);
		if(fields == null) {
			 fields = ReflectionUtil.findSimilarFields(source, dest);
			 cache.putAll(key, fields);
		}
		
		return fields;
	}
}
