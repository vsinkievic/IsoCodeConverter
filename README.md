# IsoCodeConverter
Utility classes to map and convert ISO 3166-1 country codes.

It is very easy to use as it recognizes what type of value was provided and returns value you asked. If case if provided value was not recognized RuntimeException is thrown.

# Usage examples

    assertEquals("LT", IsoCountryConverter.toAlfa2Code("lt"));
    assertEquals("LT", IsoCountryConverter.toAlfa2Code("LT"));
    assertEquals("LT", IsoCountryConverter.toAlfa2Code("LTU"));
    assertEquals("LT", IsoCountryConverter.toAlfa2Code("ltu"));
    assertEquals("LT", IsoCountryConverter.toAlfa2Code("440"));
    
    assertEquals("LTU", IsoCountryConverter.toAlfa3Code("lt"));
    assertEquals("LTU", IsoCountryConverter.toAlfa3Code("LT"));
    assertEquals("LTU", IsoCountryConverter.toAlfa3Code("LTU"));
    assertEquals("LTU", IsoCountryConverter.toAlfa3Code("ltu"));
    assertEquals("LTU", IsoCountryConverter.toAlfa3Code("440"));

    assertEquals("440", IsoCountryConverter.toNumericCode("lt"));
    assertEquals("440", IsoCountryConverter.toNumericCode("LT"));
    assertEquals("440", IsoCountryConverter.toNumericCode("LTU"));
    assertEquals("440", IsoCountryConverter.toNumericCode("ltu"));
    assertEquals("440", IsoCountryConverter.toNumericCode("440"));
    
    assertEquals("Lithuania", IsoCountryConverter.toCountryName("lt"));
    assertEquals("Lithuania", IsoCountryConverter.toCountryName("LT"));
    assertEquals("Lithuania", IsoCountryConverter.toCountryName("LTU"));
    assertEquals("Lithuania", IsoCountryConverter.toCountryName("ltu"));
    assertEquals("Lithuania", IsoCountryConverter.toCountryName("440"));

