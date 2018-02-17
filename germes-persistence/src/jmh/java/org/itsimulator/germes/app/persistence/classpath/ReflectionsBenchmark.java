package org.itsimulator.germes.app.persistence.classpath;

import javax.persistence.Entity;

import org.itsimulator.germes.app.persistence.repository.CityRepository;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.reflections.Reflections;

@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(value = 2, jvmArgsAppend = "-server")
@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
public class ReflectionsBenchmark {
	
	@Benchmark
	public void findClassesByAnnotationEntity(Blackhole blackhole) {
		Reflections reflections = new Reflections("org.itsimulator.germes.app.model.entity");

		blackhole.consume(reflections.getTypesAnnotatedWith(Entity.class));		
	}

	@Benchmark
	public void findClassesImplementingCityRepositoryInterface(Blackhole blackhole) {
		Reflections reflections = new Reflections("org.itsimulator.germes.app");

		blackhole.consume(reflections.getSubTypesOf(CityRepository.class));		
	}
	
	public static void main(String[] args) throws Exception {
		Options opts = new OptionsBuilder().include(".*").resultFormat(ResultFormatType.TEXT).build();

		new Runner(opts).run();
	}

}
