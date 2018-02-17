package org.itsimulator.germes.app.persistence.classpath;

import java.util.List;

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

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

@Warmup(iterations = 10)
@Measurement(iterations = 10)
@Fork(value = 2, jvmArgsAppend = "-server")
@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
public class FastClasspathScannerBenchmark {

	@Benchmark
	public void findClassesAsStringsByAnnotationEntity(Blackhole blackhole) {
		ScanResult scanResult = new 
				FastClasspathScanner("org.itsimulator.germes.app.model.entity").scan();

		List<String> classes = scanResult.getNamesOfClassesWithAnnotation(Entity.class);

		blackhole.consume(classes);
	}

	@Benchmark
	public void findClassesByAnnotationEntity(Blackhole blackhole) {
		ScanResult scanResult = new 
				FastClasspathScanner("org.itsimulator.germes.app.model.entity").scan();

		List<String> classes = scanResult.getNamesOfClassesWithAnnotation(Entity.class);
		
		blackhole.consume(scanResult.classNamesToClassRefs(classes));
	}

	@Benchmark
	public void findClassesAsStringsThatImplementingCityRepositoryInterface(Blackhole blackhole) {
		ScanResult scanResult = new 
				FastClasspathScanner("org.itsimulator.germes.app").scan();

		List<String> classes = scanResult.getNamesOfClassesImplementing(CityRepository.class);

		blackhole.consume(classes);
	}

	@Benchmark
	public void findClassesThatImplementingCityRepositoryInterface(Blackhole blackhole) {
		ScanResult scanResult = new 
				FastClasspathScanner("org.itsimulator.germes.app").scan();

		List<String> classes = scanResult.getNamesOfClassesImplementing(CityRepository.class);
		
		blackhole.consume(scanResult.classNamesToClassRefs(classes));
	}
	
	public static void main(String[] args) throws Exception {
		Options opts = new OptionsBuilder().include("FastClasspathScannerBenchmark").resultFormat(ResultFormatType.TEXT).build();
		new Runner(opts).run();
	}

}
