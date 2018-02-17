package org.itsimulator.germes.app.service.benchmark;

import java.util.concurrent.TimeUnit;

import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.service.transform.impl.CachedFieldProvider;
import org.itsimulator.germes.app.service.transform.impl.FieldProvider;
import org.itsimulator.germes.app.service.transform.impl.GuavaCachedFieldProvider;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Class with JMH benchmarks for FieldProvider class
 * 
 * @author Sergey
 *
 */
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(value = 2, jvmArgsAppend = "-server")
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class FieldProviderBenchmark {
	
	private FieldProvider provider; 
	
	private FieldProvider cachedProvider;
	
	private FieldProvider guavaCachedProvider;
	
	@Setup
	public void setup() {
		provider = new FieldProvider();
		cachedProvider = new CachedFieldProvider();
		guavaCachedProvider = new GuavaCachedFieldProvider(); 
	}

	@Benchmark
	public void getFieldNames_targetCityCopy() {
		provider.getFieldNames(City.class, CityCopy.class);
	}

	@Benchmark
	public void getFieldNames_targetObject() {
		provider.getFieldNames(City.class, Object.class);
	}

	@Benchmark
	public void getFieldNames_cached_targetCityCopy() {
		cachedProvider.getFieldNames(City.class, CityCopy.class);
	}

	@Benchmark
	public void getFieldNames_guava_targetObject() {
		cachedProvider.getFieldNames(City.class, Object.class);
	}

	@Benchmark
	public void getFieldNames_guava_targetCityCopy() {
		guavaCachedProvider.getFieldNames(City.class, CityCopy.class);
	}

	@Benchmark
	public void getFieldNames_cached_targetObject() {
		guavaCachedProvider.getFieldNames(City.class, Object.class);
	}
	
	public static void main(String[] args) throws Exception {
		Options opts = new OptionsBuilder().include(".*").mode(Mode.AverageTime).timeUnit(TimeUnit.NANOSECONDS)
				.resultFormat(ResultFormatType.TEXT).build();

		new Runner(opts).run();
	}

	
}
