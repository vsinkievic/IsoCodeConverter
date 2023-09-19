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

	@Test
	public void testRecognizeCodeType() {
		assertEquals(CodeType.ALFA2,        IsoCountryConverter.determineType("LT"));
		assertEquals(CodeType.ALFA2,        IsoCountryConverter.determineType("lt"));
		assertEquals(CodeType.ALFA2,        IsoCountryConverter.determineType("AA"));
		
		assertEquals(CodeType.ALFA3,        IsoCountryConverter.determineType("LTU"));
		assertEquals(CodeType.ALFA3,        IsoCountryConverter.determineType("ltu"));
		assertEquals(CodeType.ALFA3,        IsoCountryConverter.determineType("aaa"));
		
		assertEquals(CodeType.NUMERIC,      IsoCountryConverter.determineType("440"));
		assertEquals(CodeType.NUMERIC,      IsoCountryConverter.determineType("123"));
		
		assertEquals(CodeType.UNRECOGNIZED, IsoCountryConverter.determineType("L1"));
		assertEquals(CodeType.UNRECOGNIZED, IsoCountryConverter.determineType("lt2"));
		assertEquals(CodeType.UNRECOGNIZED, IsoCountryConverter.determineType(""));
		assertEquals(CodeType.UNRECOGNIZED, IsoCountryConverter.determineType(null));
	}
	
	@Test
	public void testIsCountryCode() {
		assertTrue(IsoCountryConverter.isCountryCode("LT"));
		assertTrue(IsoCountryConverter.isCountryCode("lt"));
		assertTrue(IsoCountryConverter.isCountryCode("LTU"));
		assertTrue(IsoCountryConverter.isCountryCode("ltu"));
		assertTrue(IsoCountryConverter.isCountryCode("440"));
		
		assertFalse(IsoCountryConverter.isCountryCode("AA"));
		assertFalse(IsoCountryConverter.isCountryCode("AAA"));
		assertFalse(IsoCountryConverter.isCountryCode("123"));
		
		assertFalse(IsoCountryConverter.isCountryCode("L1"));
		assertFalse(IsoCountryConverter.isCountryCode("LT1"));
		assertFalse(IsoCountryConverter.isCountryCode("123"));
		assertFalse(IsoCountryConverter.isCountryCode("LL"));
		assertFalse(IsoCountryConverter.isCountryCode("LLL"));
		assertFalse(IsoCountryConverter.isCountryCode("LLLL"));
		assertFalse(IsoCountryConverter.isCountryCode(""));
		assertFalse(IsoCountryConverter.isCountryCode(null));
	}
}
