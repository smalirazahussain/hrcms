package Utils;

import java.util.List;

public class BankReferenceUtil {

    public static List<BankReference> getBankList() {
        return List.of(
                new BankReference("Abu Dhabi Commercial Bank", "600310101", "ADCB"),
                new BankReference("Abu Dhabi Islamic Bank", "405010101", "ABDI"),
                new BankReference("Ajman Bank", "805740101", "AJMN"),
                new BankReference("Al Hilal Bank", "105310101", "HLAL"),
                new BankReference("Al Maryah Community Bank", "009710001", "AMCB"),
                new BankReference("Al Masraf Arab Bank for Investment & Foreign Trade", "100810101", "ABIN"),
                new BankReference("Bank of Sharjah", "401230101", "SHAR"),
                new BankReference("Commercial Bank International", "002220101", "CLBI"),
                new BankReference("Commercial Bank of Dubai", "102320150", "CBDU"),
                new BankReference("Dubai Bank", "005120101", "DBXP"),
                new BankReference("Dubai Islamic Bank", "802420101", "DUIB"),
                new BankReference("Emirates Investment Bank", "004820101", "AEIN"),
                new BankReference("Emirates Islamic", "703420114", "MEBL"),
                new BankReference("Emirates NBD", "302620122", "EBIL"),
                new BankReference("First Abu Dhabi Bank", "803510106", "NBAD"),
                new BankReference("Invest Bank", "503030102", "IBTF"),
                new BankReference("Mashreq", "203320101", "BOML"),
                new BankReference("National Bank of Fujairah", "703820101", "NBFU"),
                new BankReference("National Bank of Ras Al-Khaimah PJSC (RAKBANK)", "104060106", "NRAK"),
                new BankReference("National Bank of Umm Al-Quwain", "104251001", "UMMQ"),
                new BankReference("Noor Bank", "905220101", "NISL"),
                new BankReference("Sharjah Islamic Bank", "404130101", "NBSH"),
                new BankReference("United Arab Bank", "904630101", "UARB"),
                new BankReference("United Bank Ltd.", "604720106", "UNIL"),
                new BankReference("Standard Chartered Bank", "504420120", "SCBL"),
                new BankReference("Saudi National Bank", "605520101", "SAMB"),
                new BankReference("Rafidain Bank", "400510101", "RAFB"),
                new BankReference("National Bank of Oman", "903910101", "NBOM"),
                new BankReference("National Bank of Kuwait", "505620101", "NBOK"),
                new BankReference("National Bank of Bahrain", "203610101", "NBOB"),
                new BankReference("MCB Bank Limited", "209120101", "MUCBPKKANGL"),
                new BankReference("KEB Hana Bank", "408910101", "KEB"),
                new BankReference("Janata Bank Limited", "103110110", "JANB"),
                new BankReference("Intesa Sanpaolo S.P.A", "309314334", "ISP"),
                new BankReference("Industrial & Commercial Bank of China", "804310101", "ICBK"),
                new BankReference("HSBC Bank Middle East Limited", "302020120", "BBME"),
                new BankReference("Habib Bank Ltd.", "102820111", "HABB"),
                new BankReference("Habib Bank A.G Zurich", "302920101", "HBZU"),
                new BankReference("Gulf International Bank", "509210001", "GIB"),
                new BankReference("El Nilein Bank", "002510101", "NILB"),
                new BankReference("Doha Bank", "705420101", "DOHB"),
                new BankReference("Deutsche Bank AG", "204910101", "DEUT"),
                new BankReference("Credit Agricloe", "301620101", "BSUI"),
                new BankReference("CitiBank N. A.", "102120101", "CITI"),
                new BankReference("BNP Paribas", "401810101", "BNPA"),
                new BankReference("Barclays Bank PLC", "401920110", "BARC"),
                new BankReference("Banque Misr", "001510102", "BMIS"),
                new BankReference("Bank Saderat Iran", "901320124", "BSIR"),
                new BankReference("Bank of China Limited", "309010188", "BOC"),
                new BankReference("Bank of Baroda", "801120101", "BARB"),
                new BankReference("Bank Melli Iran", "901020101", "MELI"),
                new BankReference("Bank Al Falah Limited", "009920501", "BAFL"),
                new BankReference("Arab Bank", "000910101", "ARAB"),
                new BankReference("Arab African International Bank", "900720101", "ARAI"),
                new BankReference("Al Khaliji", "201720101", "LICO"),
                new BankReference("Al Ahli Bank of Kuwait", "200420101", "ABKK"),
                new BankReference("Agricultural Bank of China Ltd.", "709820785", "ABC"),
                new BankReference("Bank of America, N.A. (Canada)", "000910101", "ARAB"),
                new BankReference("Royal Bank of Canada", "002220101", "CLBI"),
                new BankReference("The Bank of Nova Scotia", "002620132", "BNS"),
                new BankReference("Canadian Imperial Bank of Commerce", "009710001", "CIBC"),
                new BankReference("FirstBank", "102710102", "FGBM"),
                new BankReference("HSBC Bank USA", "202620103", "EBIL"),
                new BankReference("Regions Bank", "205010141", "RF"),
                new BankReference("BancFirst", "305012577", "RF"),
                new BankReference("Bank of Oklahoma, N.A.", "305031064", "BOKF"),
                new BankReference("PNC Bank, N.A.", "502320103", "PNC"),
                new BankReference("TCF National Bank", "503870102", "HBAN"),
                new BankReference("First Hawaiian Bank", "600930105", "TCF"),
                new BankReference("Bank of America, N.A. (Hawaii)", "602440109", "BOH"),
                new BankReference("Charles Schwab Bank, SSB", "643140101", "SCHW"),
                new BankReference("Deutsche Bank Trust Company Americas", "704510131", "UNBE"),
                new BankReference("Commerce Bank", "705010403", "CBSH"),
                new BankReference("UMB Bank, N.A.", "705020103", "UMBF"),
                new BankReference("U.S. Bank National Association", "705040116", "USB"),
                new BankReference("First Financial Bank, N.A.", "740810000", "FFIN"),
                new BankReference("Zions First National Bank", "803720101", "ZION"),
                new BankReference("Ruya Community Islamic Bank LLC", "413240101", "RCIB")
        );
    }

    public static boolean isValidBankCombo(String bankName, String routingCode, String shortCode) {
        return getBankList().stream().anyMatch(bank ->
                bank.getName().equalsIgnoreCase(bankName) &&
                        bank.getRoutingCode().equals(routingCode) &&
                        bank.getShortCode().equalsIgnoreCase(shortCode)
        );
    }
}
