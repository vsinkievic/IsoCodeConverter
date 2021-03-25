package com.bpmid.utilities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class IsoCountryConverter {
	
	private static HashMap<String, Country> byAlfa2Code;
	private static HashMap<String, Country> byAlfa3Code;
	private static HashMap<String, Country> byNumericCode;
	private static boolean wasInitialized = false;
	
	public static String toAlfa2Code(String code) {
		if (!wasInitialized)
			init();
		
		if (_isBlank(code))
			return code;
		
		return findCountry(code)
				.orElseThrow(() -> new RuntimeException(String.format("Failed to find country by string '%s'", code)))
				.getAlfa2Code();
	}
	public static String toAlfa3Code(String code) {
		if (!wasInitialized)
			init();

		if (_isBlank(code))
			return code;

		return findCountry(code)
				.orElseThrow(() -> new RuntimeException(String.format("Failed to find country by string '%s'", code)))
				.getAlfa3Code();
	}
	public static String toNumericCode(String code) {
		if (!wasInitialized)
			init();
		
		if (_isBlank(code))
			return code;
		
		return findCountry(code)
				.orElseThrow(() -> new RuntimeException(String.format("Failed to find country by string '%s'", code)))
				.getNumericCode();
	}
	public static String toCountryName(String code) {
		if (!wasInitialized)
			init();
		
		if (_isBlank(code))
			return code;
		
		return findCountry(code)
				.orElseThrow(() -> new RuntimeException(String.format("Failed to find country by string '%s'", code)))
				.getCountryName();
	}

	private static void init() {
		Set<Country> countries = initCountries();
		
		byAlfa2Code = new HashMap<String, Country>();
		byAlfa3Code = new HashMap<String, Country>();
		byNumericCode = new HashMap<String, Country>();
		for(Country c : countries) {
			byAlfa2Code.put(c.getAlfa2Code(), c);
			byAlfa3Code.put(c.getAlfa3Code(), c);
			byNumericCode.put(c.getNumericCode(), c);
		}
		wasInitialized = true;
	}
	
	private static boolean _isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
	
	private static Set<Country> initCountries(){
		HashSet<Country> countries = new HashSet<Country>();
		
		countries.add(new Country("AF", "AFG", "004", "Afghanistan                                               "));
		countries.add(new Country("AL", "ALB", "008", "Albania                                                   "));
		countries.add(new Country("AQ", "ATA", "010", "Antarctica                                                "));
		countries.add(new Country("DZ", "DZA", "012", "Algeria                                                   "));
		countries.add(new Country("AS", "ASM", "016", "American Samoa                                            "));
		countries.add(new Country("AD", "AND", "020", "Andorra                                                   "));
		countries.add(new Country("AO", "AGO", "024", "Angola                                                    "));
		countries.add(new Country("AG", "ATG", "028", "Antigua and Barbuda                                       "));
		countries.add(new Country("AZ", "AZE", "031", "Azerbaijan                                                "));
		countries.add(new Country("AR", "ARG", "032", "Argentina                                                 "));
		countries.add(new Country("AU", "AUS", "036", "Australia                                                 "));
		countries.add(new Country("AT", "AUT", "040", "Austria                                                   "));
		countries.add(new Country("BS", "BHS", "044", "Bahamas (the)                                             "));
		countries.add(new Country("BH", "BHR", "048", "Bahrain                                                   "));
		countries.add(new Country("BD", "BGD", "050", "Bangladesh                                                "));
		countries.add(new Country("AM", "ARM", "051", "Armenia                                                   "));
		countries.add(new Country("BB", "BRB", "052", "Barbados                                                  "));
		countries.add(new Country("BE", "BEL", "056", "Belgium                                                   "));
		countries.add(new Country("BM", "BMU", "060", "Bermuda                                                   "));
		countries.add(new Country("BT", "BTN", "064", "Bhutan                                                    "));
		countries.add(new Country("BO", "BOL", "068", "Bolivia (Plurinational State of)                          "));
		countries.add(new Country("BA", "BIH", "070", "Bosnia and Herzegovina                                    "));
		countries.add(new Country("BW", "BWA", "072", "Botswana                                                  "));
		countries.add(new Country("BV", "BVT", "074", "Bouvet Island                                             "));
		countries.add(new Country("BR", "BRA", "076", "Brazil                                                    "));
		countries.add(new Country("BZ", "BLZ", "084", "Belize                                                    "));
		countries.add(new Country("IO", "IOT", "086", "British Indian Ocean Territory (the)                      "));
		countries.add(new Country("SB", "SLB", "090", "Solomon Islands                                           "));
		countries.add(new Country("VG", "VGB", "092", "Virgin Islands (British)                                  "));
		countries.add(new Country("BN", "BRN", "096", "Brunei Darussalam                                         "));
		countries.add(new Country("BG", "BGR", "100", "Bulgaria                                                  "));
		countries.add(new Country("MM", "MMR", "104", "Myanmar                                                   "));
		countries.add(new Country("BI", "BDI", "108", "Burundi                                                   "));
		countries.add(new Country("BY", "BLR", "112", "Belarus                                                   "));
		countries.add(new Country("KH", "KHM", "116", "Cambodia                                                  "));
		countries.add(new Country("CM", "CMR", "120", "Cameroon                                                  "));
		countries.add(new Country("CA", "CAN", "124", "Canada                                                    "));
		countries.add(new Country("CV", "CPV", "132", "Cabo Verde                                                "));
		countries.add(new Country("KY", "CYM", "136", "Cayman Islands (the)                                      "));
		countries.add(new Country("CF", "CAF", "140", "Central African Republic (the)                            "));
		countries.add(new Country("LK", "LKA", "144", "Sri Lanka                                                 "));
		countries.add(new Country("TD", "TCD", "148", "Chad                                                      "));
		countries.add(new Country("CL", "CHL", "152", "Chile                                                     "));
		countries.add(new Country("CN", "CHN", "156", "China                                                     "));
		countries.add(new Country("TW", "TWN", "158", "Taiwan (Province of China)                                "));
		countries.add(new Country("CX", "CXR", "162", "Christmas Island                                          "));
		countries.add(new Country("CC", "CCK", "166", "Cocos (Keeling) Islands (the)                             "));
		countries.add(new Country("CO", "COL", "170", "Colombia                                                  "));
		countries.add(new Country("KM", "COM", "174", "Comoros (the)                                             "));
		countries.add(new Country("YT", "MYT", "175", "Mayotte                                                   "));
		countries.add(new Country("CG", "COG", "178", "Congo (the)                                               "));
		countries.add(new Country("CD", "COD", "180", "Congo (the Democratic Republic of the)                    "));
		countries.add(new Country("CK", "COK", "184", "Cook Islands (the)                                        "));
		countries.add(new Country("CR", "CRI", "188", "Costa Rica                                                "));
		countries.add(new Country("HR", "HRV", "191", "Croatia                                                   "));
		countries.add(new Country("CU", "CUB", "192", "Cuba                                                      "));
		countries.add(new Country("CY", "CYP", "196", "Cyprus                                                    "));
		countries.add(new Country("CZ", "CZE", "203", "Czechia                                                   "));
		countries.add(new Country("BJ", "BEN", "204", "Benin                                                     "));
		countries.add(new Country("DK", "DNK", "208", "Denmark                                                   "));
		countries.add(new Country("DM", "DMA", "212", "Dominica                                                  "));
		countries.add(new Country("DO", "DOM", "214", "Dominican Republic (the)                                  "));
		countries.add(new Country("EC", "ECU", "218", "Ecuador                                                   "));
		countries.add(new Country("SV", "SLV", "222", "El Salvador                                               "));
		countries.add(new Country("GQ", "GNQ", "226", "Equatorial Guinea                                         "));
		countries.add(new Country("ET", "ETH", "231", "Ethiopia                                                  "));
		countries.add(new Country("ER", "ERI", "232", "Eritrea                                                   "));
		countries.add(new Country("EE", "EST", "233", "Estonia                                                   "));
		countries.add(new Country("FO", "FRO", "234", "Faroe Islands (the)                                       "));
		countries.add(new Country("FK", "FLK", "238", "Falkland Islands (the) [Malvinas]                         "));
		countries.add(new Country("GS", "SGS", "239", "South Georgia and the South Sandwich Islands              "));
		countries.add(new Country("FJ", "FJI", "242", "Fiji                                                      "));
		countries.add(new Country("FI", "FIN", "246", "Finland                                                   "));
		countries.add(new Country("AX", "ALA", "248", "Åland Islands                                             "));
		countries.add(new Country("FR", "FRA", "250", "France                                                    "));
		countries.add(new Country("GF", "GUF", "254", "French Guiana                                             "));
		countries.add(new Country("PF", "PYF", "258", "French Polynesia                                          "));
		countries.add(new Country("TF", "ATF", "260", "French Southern Territories (the)                         "));
		countries.add(new Country("DJ", "DJI", "262", "Djibouti                                                  "));
		countries.add(new Country("GA", "GAB", "266", "Gabon                                                     "));
		countries.add(new Country("GE", "GEO", "268", "Georgia                                                   "));
		countries.add(new Country("GM", "GMB", "270", "Gambia (the)                                              "));
		countries.add(new Country("PS", "PSE", "275", "Palestine, State of                                       "));
		countries.add(new Country("DE", "DEU", "276", "Germany                                                   "));
		countries.add(new Country("GH", "GHA", "288", "Ghana                                                     "));
		countries.add(new Country("GI", "GIB", "292", "Gibraltar                                                 "));
		countries.add(new Country("KI", "KIR", "296", "Kiribati                                                  "));
		countries.add(new Country("GR", "GRC", "300", "Greece                                                    "));
		countries.add(new Country("GL", "GRL", "304", "Greenland                                                 "));
		countries.add(new Country("GD", "GRD", "308", "Grenada                                                   "));
		countries.add(new Country("GP", "GLP", "312", "Guadeloupe                                                "));
		countries.add(new Country("GU", "GUM", "316", "Guam                                                      "));
		countries.add(new Country("GT", "GTM", "320", "Guatemala                                                 "));
		countries.add(new Country("GN", "GIN", "324", "Guinea                                                    "));
		countries.add(new Country("GY", "GUY", "328", "Guyana                                                    "));
		countries.add(new Country("HT", "HTI", "332", "Haiti                                                     "));
		countries.add(new Country("HM", "HMD", "334", "Heard Island and McDonald Islands                         "));
		countries.add(new Country("VA", "VAT", "336", "Holy See (the)                                            "));
		countries.add(new Country("HN", "HND", "340", "Honduras                                                  "));
		countries.add(new Country("HK", "HKG", "344", "Hong Kong                                                 "));
		countries.add(new Country("HU", "HUN", "348", "Hungary                                                   "));
		countries.add(new Country("IS", "ISL", "352", "Iceland                                                   "));
		countries.add(new Country("IN", "IND", "356", "India                                                     "));
		countries.add(new Country("ID", "IDN", "360", "Indonesia                                                 "));
		countries.add(new Country("IR", "IRN", "364", "Iran (Islamic Republic of)                                "));
		countries.add(new Country("IQ", "IRQ", "368", "Iraq                                                      "));
		countries.add(new Country("IE", "IRL", "372", "Ireland                                                   "));
		countries.add(new Country("IL", "ISR", "376", "Israel                                                    "));
		countries.add(new Country("IT", "ITA", "380", "Italy                                                     "));
		countries.add(new Country("CI", "CIV", "384", "Cote d'Ivoire                                             "));
		countries.add(new Country("JM", "JAM", "388", "Jamaica                                                   "));
		countries.add(new Country("JP", "JPN", "392", "Japan                                                     "));
		countries.add(new Country("KZ", "KAZ", "398", "Kazakhstan                                                "));
		countries.add(new Country("JO", "JOR", "400", "Jordan                                                    "));
		countries.add(new Country("KE", "KEN", "404", "Kenya                                                     "));
		countries.add(new Country("KP", "PRK", "408", "Korea (the Democratic People's Republic of)               "));
		countries.add(new Country("KR", "KOR", "410", "Korea (the Republic of)                                   "));
		countries.add(new Country("KW", "KWT", "414", "Kuwait                                                    "));
		countries.add(new Country("KG", "KGZ", "417", "Kyrgyzstan                                                "));
		countries.add(new Country("LA", "LAO", "418", "Lao People's Democratic Republic (the)                    "));
		countries.add(new Country("LB", "LBN", "422", "Lebanon                                                   "));
		countries.add(new Country("LS", "LSO", "426", "Lesotho                                                   "));
		countries.add(new Country("LV", "LVA", "428", "Latvia                                                    "));
		countries.add(new Country("LR", "LBR", "430", "Liberia                                                   "));
		countries.add(new Country("LY", "LBY", "434", "Libya                                                     "));
		countries.add(new Country("LI", "LIE", "438", "Liechtenstein                                             "));
		countries.add(new Country("LT", "LTU", "440", "Lithuania                                                 "));
		countries.add(new Country("LU", "LUX", "442", "Luxembourg                                                "));
		countries.add(new Country("MO", "MAC", "446", "Macao                                                     "));
		countries.add(new Country("MG", "MDG", "450", "Madagascar                                                "));
		countries.add(new Country("MW", "MWI", "454", "Malawi                                                    "));
		countries.add(new Country("MY", "MYS", "458", "Malaysia                                                  "));
		countries.add(new Country("MV", "MDV", "462", "Maldives                                                  "));
		countries.add(new Country("ML", "MLI", "466", "Mali                                                      "));
		countries.add(new Country("MT", "MLT", "470", "Malta                                                     "));
		countries.add(new Country("MQ", "MTQ", "474", "Martinique                                                "));
		countries.add(new Country("MR", "MRT", "478", "Mauritania                                                "));
		countries.add(new Country("MU", "MUS", "480", "Mauritius                                                 "));
		countries.add(new Country("MX", "MEX", "484", "Mexico                                                    "));
		countries.add(new Country("MC", "MCO", "492", "Monaco                                                    "));
		countries.add(new Country("MN", "MNG", "496", "Mongolia                                                  "));
		countries.add(new Country("MD", "MDA", "498", "Moldova (the Republic of)                                 "));
		countries.add(new Country("ME", "MNE", "499", "Montenegro                                                "));
		countries.add(new Country("MS", "MSR", "500", "Montserrat                                                "));
		countries.add(new Country("MA", "MAR", "504", "Morocco                                                   "));
		countries.add(new Country("MZ", "MOZ", "508", "Mozambique                                                "));
		countries.add(new Country("OM", "OMN", "512", "Oman                                                      "));
		countries.add(new Country("NA", "NAM", "516", "Namibia                                                   "));
		countries.add(new Country("NR", "NRU", "520", "Nauru                                                     "));
		countries.add(new Country("NP", "NPL", "524", "Nepal                                                     "));
		countries.add(new Country("NL", "NLD", "528", "Netherlands (the)                                         "));
		countries.add(new Country("CW", "CUW", "531", "Curacao                                                   "));
		countries.add(new Country("AW", "ABW", "533", "Aruba                                                     "));
		countries.add(new Country("SX", "SXM", "534", "Sint Maarten (Dutch part)                                 "));
		countries.add(new Country("BQ", "BES", "535", "Bonaire, Sint Eustatius and Saba                          "));
		countries.add(new Country("NC", "NCL", "540", "New Caledonia                                             "));
		countries.add(new Country("VU", "VUT", "548", "Vanuatu                                                   "));
		countries.add(new Country("NZ", "NZL", "554", "New Zealand                                               "));
		countries.add(new Country("NI", "NIC", "558", "Nicaragua                                                 "));
		countries.add(new Country("NE", "NER", "562", "Niger (the)                                               "));
		countries.add(new Country("NG", "NGA", "566", "Nigeria                                                   "));
		countries.add(new Country("NU", "NIU", "570", "Niue                                                      "));
		countries.add(new Country("NF", "NFK", "574", "Norfolk Island                                            "));
		countries.add(new Country("NO", "NOR", "578", "Norway                                                    "));
		countries.add(new Country("MP", "MNP", "580", "Northern Mariana Islands (the)                            "));
		countries.add(new Country("UM", "UMI", "581", "United States Minor Outlying Islands (the)                "));
		countries.add(new Country("FM", "FSM", "583", "Micronesia (Federated States of)                          "));
		countries.add(new Country("MH", "MHL", "584", "Marshall Islands (the)                                    "));
		countries.add(new Country("PW", "PLW", "585", "Palau                                                     "));
		countries.add(new Country("PK", "PAK", "586", "Pakistan                                                  "));
		countries.add(new Country("PA", "PAN", "591", "Panama                                                    "));
		countries.add(new Country("PG", "PNG", "598", "Papua New Guinea                                          "));
		countries.add(new Country("PY", "PRY", "600", "Paraguay                                                  "));
		countries.add(new Country("PE", "PER", "604", "Peru                                                      "));
		countries.add(new Country("PH", "PHL", "608", "Philippines (the)                                         "));
		countries.add(new Country("PN", "PCN", "612", "Pitcairn                                                  "));
		countries.add(new Country("PL", "POL", "616", "Poland                                                    "));
		countries.add(new Country("PT", "PRT", "620", "Portugal                                                  "));
		countries.add(new Country("GW", "GNB", "624", "Guinea-Bissau                                             "));
		countries.add(new Country("TL", "TLS", "626", "Timor-Leste                                               "));
		countries.add(new Country("PR", "PRI", "630", "Puerto Rico                                               "));
		countries.add(new Country("QA", "QAT", "634", "Qatar                                                     "));
		countries.add(new Country("RE", "REU", "638", "Réunion                                                   "));
		countries.add(new Country("RO", "ROU", "642", "Romania                                                   "));
		countries.add(new Country("RU", "RUS", "643", "Russian Federation (the)                                  "));
		countries.add(new Country("RW", "RWA", "646", "Rwanda                                                    "));
		countries.add(new Country("BL", "BLM", "652", "Saint Barthélemy                                          "));
		countries.add(new Country("SH", "SHN", "654", "Saint Helena, Ascension and Tristan da Cunha              "));
		countries.add(new Country("KN", "KNA", "659", "Saint Kitts and Nevis                                     "));
		countries.add(new Country("AI", "AIA", "660", "Anguilla                                                  "));
		countries.add(new Country("LC", "LCA", "662", "Saint Lucia                                               "));
		countries.add(new Country("MF", "MAF", "663", "Saint Martin (French part)                                "));
		countries.add(new Country("PM", "SPM", "666", "Saint Pierre and Miquelon                                 "));
		countries.add(new Country("VC", "VCT", "670", "Saint Vincent and the Grenadines                          "));
		countries.add(new Country("SM", "SMR", "674", "San Marino                                                "));
		countries.add(new Country("ST", "STP", "678", "Sao Tome and Principe                                     "));
		countries.add(new Country("SA", "SAU", "682", "Saudi Arabia                                              "));
		countries.add(new Country("SN", "SEN", "686", "Senegal                                                   "));
		countries.add(new Country("RS", "SRB", "688", "Serbia                                                    "));
		countries.add(new Country("SC", "SYC", "690", "Seychelles                                                "));
		countries.add(new Country("SL", "SLE", "694", "Sierra Leone                                              "));
		countries.add(new Country("SG", "SGP", "702", "Singapore                                                 "));
		countries.add(new Country("SK", "SVK", "703", "Slovakia                                                  "));
		countries.add(new Country("VN", "VNM", "704", "Viet Nam                                                  "));
		countries.add(new Country("SI", "SVN", "705", "Slovenia                                                  "));
		countries.add(new Country("SO", "SOM", "706", "Somalia                                                   "));
		countries.add(new Country("ZA", "ZAF", "710", "South Africa                                              "));
		countries.add(new Country("ZW", "ZWE", "716", "Zimbabwe                                                  "));
		countries.add(new Country("ES", "ESP", "724", "Spain                                                     "));
		countries.add(new Country("SS", "SSD", "728", "South Sudan                                               "));
		countries.add(new Country("SD", "SDN", "729", "Sudan (the)                                               "));
		countries.add(new Country("EH", "ESH", "732", "Western Sahara*                                           "));
		countries.add(new Country("SR", "SUR", "740", "Suriname                                                  "));
		countries.add(new Country("SJ", "SJM", "744", "Svalbard and Jan Mayen                                    "));
		countries.add(new Country("SZ", "SWZ", "748", "Eswatini                                                  "));
		countries.add(new Country("SE", "SWE", "752", "Sweden                                                    "));
		countries.add(new Country("CH", "CHE", "756", "Switzerland                                               "));
		countries.add(new Country("SY", "SYR", "760", "Syrian Arab Republic (the)                                "));
		countries.add(new Country("TJ", "TJK", "762", "Tajikistan                                                "));
		countries.add(new Country("TH", "THA", "764", "Thailand                                                  "));
		countries.add(new Country("TG", "TGO", "768", "Togo                                                      "));
		countries.add(new Country("TK", "TKL", "772", "Tokelau                                                   "));
		countries.add(new Country("TO", "TON", "776", "Tonga                                                     "));
		countries.add(new Country("TT", "TTO", "780", "Trinidad and Tobago                                       "));
		countries.add(new Country("AE", "ARE", "784", "United Arab Emirates (the)                                "));
		countries.add(new Country("TN", "TUN", "788", "Tunisia                                                   "));
		countries.add(new Country("TR", "TUR", "792", "Turkey                                                    "));
		countries.add(new Country("TM", "TKM", "795", "Turkmenistan                                              "));
		countries.add(new Country("TC", "TCA", "796", "Turks and Caicos Islands (the)                            "));
		countries.add(new Country("TV", "TUV", "798", "Tuvalu                                                    "));
		countries.add(new Country("UG", "UGA", "800", "Uganda                                                    "));
		countries.add(new Country("UA", "UKR", "804", "Ukraine                                                   "));
		countries.add(new Country("MK", "MKD", "807", "North Macedonia                                           "));
		countries.add(new Country("EG", "EGY", "818", "Egypt                                                     "));
		countries.add(new Country("GB", "GBR", "826", "United Kingdom of Great Britain and Northern Ireland (the)"));
		countries.add(new Country("GG", "GGY", "831", "Guernsey                                                  "));
		countries.add(new Country("JE", "JEY", "832", "Jersey                                                    "));
		countries.add(new Country("IM", "IMN", "833", "Isle of Man                                               "));
		countries.add(new Country("TZ", "TZA", "834", "Tanzania, the United Republic of                          "));
		countries.add(new Country("US", "USA", "840", "United States of America (the)                            "));
		countries.add(new Country("VI", "VIR", "850", "Virgin Islands (U.S.)                                     "));
		countries.add(new Country("BF", "BFA", "854", "Burkina Faso                                              "));
		countries.add(new Country("UY", "URY", "858", "Uruguay                                                   "));
		countries.add(new Country("UZ", "UZB", "860", "Uzbekistan                                                "));
		countries.add(new Country("VE", "VEN", "862", "Venezuela (Bolivarian Republic of)                        "));
		countries.add(new Country("WF", "WLF", "876", "Wallis and Futuna                                         "));
		countries.add(new Country("WS", "WSM", "882", "Samoa                                                     "));
		countries.add(new Country("YE", "YEM", "887", "Yemen                                                     "));
		countries.add(new Country("ZM", "ZMB", "894", "Zambia                                                    "));
		
		return countries;
	}
	
	private static Optional<Country> findCountry(String code){
		String upperCode = null;
		
		switch(determineType(code)) {
		case ALFA2:
			upperCode = code.toUpperCase();
			if (byAlfa2Code.containsKey(upperCode))
				return Optional.of(byAlfa2Code.get(upperCode));
			else
				return Optional.empty();
			
		case ALFA3:
			upperCode = code.toUpperCase();
			if (byAlfa3Code.containsKey(upperCode))
				return Optional.of(byAlfa3Code.get(upperCode));
			else
				return Optional.empty();

		case NUMERIC:
			if (byNumericCode.containsKey(code))
				return Optional.of(byNumericCode.get(code));
			else
				return Optional.empty();
		default:
			return Optional.empty();
		}
	}
	
	private static CodeType determineType(String code) {
		
		if (code == null || code.isEmpty())
			return CodeType.UNRECOGNIZED;
		switch (code.length()) {
		case 2:
			return CodeType.ALFA2;
		case 3:
			if (code.matches("[0-9]+"))
				return CodeType.NUMERIC;
			else 
				return CodeType.ALFA3;
			default:
				return CodeType.UNRECOGNIZED;
		}
	}
	private enum CodeType {
		ALFA2,
		ALFA3,
		NUMERIC,
		UNRECOGNIZED;
	}
}
