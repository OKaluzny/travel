package org.itsimulator.germes.app.service.benchmark;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.itsimulator.germes.app.model.entity.base.AbstractEntity;
import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.entity.geography.Station;
import org.itsimulator.germes.app.service.transform.impl.FieldProvider;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Class with JMH benchmarks for FieldProvider class
 * @author Sergey
 *
 */
public class FieldProviderBenchmark {

	@Benchmark
    public void testFieldProvider_getFieldNames() {
		FieldProvider provider = new FieldProvider();
		provider.getFieldNames(City.class, CityCopy.class);
    }
	
	public static void main(String[] args) throws Exception {
		Options opts = new OptionsBuilder().include(".*").mode(Mode.AverageTime).timeUnit(TimeUnit.NANOSECONDS).jvmArgs("-server")
				.resultFormat(ResultFormatType.TEXT).build();

		new Runner(opts).run();
	}
	
	public static class CityCopy extends AbstractEntity {
		private String name;

		private String district;

		private String region;

		private Set<Station> stations;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDistrict() {
			return district;
		}

		public void setDistrict(String district) {
			this.district = district;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public Set<Station> getStations() {
			return stations;
		}

		public void setStations(Set<Station> stations) {
			this.stations = stations;
		}
	}
}
