package com.bpmid.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsoCountryConverterTest {

	@Test
	public void testLithuania() {
		assertEquals("LT", IsoCountryConverter.toAlfa2Code("lt"));
		assertEquals("LT", IsoCountryConverter.toAlfa2Code("LT"));
		assertEquals("LT", IsoCountryConverter.toAlfa2Code("LTU"));
		assertEquals("LT", IsoCountryConverter.toAlfa2Code("ltu"));
		assertEquals("LT", IsoCountryConverter.toAlfa2Code("440"));
		assertEquals("", IsoCountryConverter.toAlfa2Code(""));
		assertNull(IsoCountryConverter.toAlfa2Code(null));

		assertEquals("LTU", IsoCountryConverter.toAlfa3Code("lt"));
		assertEquals("LTU", IsoCountryConverter.toAlfa3Code("LT"));
		assertEquals("LTU", IsoCountryConverter.toAlfa3Code("LTU"));
		assertEquals("LTU", IsoCountryConverter.toAlfa3Code("ltu"));
		assertEquals("LTU", IsoCountryConverter.toAlfa3Code("440"));
		assertEquals("", IsoCountryConverter.toAlfa3Code(""));
		assertNull(IsoCountryConverter.toAlfa3Code(null));

		assertEquals("440", IsoCountryConverter.toNumericCode("lt"));
		assertEquals("440", IsoCountryConverter.toNumericCode("LT"));
		assertEquals("440", IsoCountryConverter.toNumericCode("LTU"));
		assertEquals("440", IsoCountryConverter.toNumericCode("ltu"));
		assertEquals("440", IsoCountryConverter.toNumericCode("440"));
		assertEquals("", IsoCountryConverter.toNumericCode(""));
		assertNull(IsoCountryConverter.toNumericCode(null));

		assertEquals("Lithuania", IsoCountryConverter.toCountryName("lt"));
		assertEquals("Lithuania", IsoCountryConverter.toCountryName("LT"));
		assertEquals("Lithuania", IsoCountryConverter.toCountryName("LTU"));
		assertEquals("Lithuania", IsoCountryConverter.toCountryName("ltu"));
		assertEquals("Lithuania", IsoCountryConverter.toCountryName("440"));
		assertEquals("", IsoCountryConverter.toCountryName(""));
		assertNull(IsoCountryConverter.toCountryName(null));

	}

}
