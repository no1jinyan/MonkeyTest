package com.bankht.monkey.regex;

import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
import java.util.Hashtable;  
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
  
public class Validator {  
    /** 
     * �̶��绰��֤ 
     * 
     * ��ʽΪ: 0XXX-XXXXXX(10-13λ��λ����Ϊ0) ��0XXX XXXXXXX(10-13λ��λ����Ϊ0) �� 
     * (0XXX)XXXXXXXX(11-14λ��λ����Ϊ0) �� XXXXXXXX(6-8λ��λ��Ϊ0) �� 
     * XXXXXXXXXXX(11λ��λ��Ϊ0)  
     * 
     * ƥ�� : 0371-123456 �� (0371)1234567 �� (0371)12345678 �� 010-123456 �� 
     * 010-12345678 �� 12345678912  
     * 
     * ��ƥ��: 1111-134355 �� 0123456789 
     * @param phoneNumber 
     * @return 
     */  
    public static boolean phoneNumberValidate(String phoneNumber){  
        String phone_regex = "^(?:0[0-9]{2,4}[-\\s]{1}|\\(0[0-9]{2,4}\\))[0-9]{6,8}$|^[0-9]{6,8}$";  
        Pattern phone_pattern = Pattern.compile(phone_regex);  
        Matcher phone_matcher = phone_pattern.matcher(phoneNumber);  
        if (phone_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
    /** 
     * �ʱ������֤ 
     * 
     * ��ʽΪ: XXXXXX(6λ) 
     * 
     * ƥ�� : 012345  
     * 
     * ��ƥ��: 0123456 
     * @param code 
     * @return 
     */  
    public static boolean codeValidate(String code){  
        String code_regex = "^[0-9]{6}$";  
        Pattern code_pattern = Pattern.compile(code_regex);  
        Matcher code_matcher = code_pattern.matcher(code);  
        if (code_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
    /** 
     * �ֻ�������֤ 
     *  
     * �ƶ���134��135��136��137��138��139��150��151��157(TD)��158��159��187��188  
     *  
     * ��ͨ��130��131��132��152��155��156��185��186  
     *  
     * ���ţ�133��153��180��189����1349��ͨ�� 
     * @param telNumber 
     * @return 
     */  
    public static boolean telValidate(String telNumber){  
        String tel_regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";  
        Pattern tel_pattern = Pattern.compile(tel_regex);  
        Matcher tel_matcher = tel_pattern.matcher(telNumber);  
        if (tel_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
    /** 
     * ���֤������֤ 
     *  
     * ���忴IdentityCard�� 
     * @param cardId 
     * @return 
     * @throws ParseException 
     */  
    public static boolean idValidate(String cardId) throws ParseException{  
        String error = idCardValidate(cardId);  
        if (error.equals("")) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
    /** 
     * �û��˺ź͹���Ա�˺� 
     *  
     * ��ĸ��ͷ������5-20�ֽڣ�������ĸ�����»��� 
     *  
     * @param account 
     * @return 
     */  
    public static boolean accountValidate(String account){  
        String accountRegex = "^[a-zA-Z][a-zA-Z0-9_]{4,19}$";  
        Pattern account_pattern = Pattern.compile(accountRegex);  
        Matcher account_matcher = account_pattern.matcher(account);  
        if (account_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
    /** 
     * ������֤ 
     *  
     * ƥ������ʹ���ַ�+����+�����ַ���!@#$%&����ʽ���������볤��5~20λ 
     *  
     * @param password 
     * @return 
     */  
    public static boolean passwordValidate(String password){  
        String passRegex = "^[\\dA-Za-z(!@#$%&)]{4,19}$";  
        Pattern pass_pattern =Pattern.compile(passRegex);  
        Matcher pass_matcher = pass_pattern.matcher(password);  
        if (pass_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
      
    /** 
     * ������֤��ƥ��󲿷ָ�ʽ 
     *  
     * @param email 
     * @return 
     */  
    public static boolean emailValidate(String email){  
        String emailRegex = "^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$";  
        Pattern email_pattern = Pattern.compile(emailRegex);  
        Matcher email_matcher = email_pattern.matcher(email);  
        if (email_matcher.matches()) {  
            return true;  
        }else {  
            return false;  
        }  
    }  
      
      
    /*********************************** ���֤��֤��ʼ ****************************************/    
    /** 
     * ���֤������֤  
     * 1������Ľṹ 
     * ������ݺ�������������룬��ʮ��λ���ֱ������һλУ������ɡ�����˳�������������Ϊ����λ���ֵ�ַ�룬 
     * ��λ���ֳ��������룬��λ����˳�����һλ����У���롣 
     * 2����ַ��(ǰ��λ����  
     * ��ʾ�������ס����������(�С��졢��)�������������룬��GB/T2260�Ĺ涨ִ�С�  
     * 3�����������루����λ��ʮ��λ�� 
     * ��ʾ�������������ꡢ�¡��գ���GB/T7408�Ĺ涨ִ�У��ꡢ�¡��մ���֮�䲻�÷ָ�����  
     * 4��˳���루��ʮ��λ��ʮ��λ�� 
     * ��ʾ��ͬһ��ַ������ʶ������Χ�ڣ���ͬ�ꡢͬ�¡�ͬ�ճ������˱ඨ��˳��ţ� 
     * ˳�����������������ԣ�ż�������Ů�ԡ�  
     * 5��У���루��ʮ��λ���� 
     * ��1��ʮ��λ���ֱ������Ȩ��͹�ʽ S = Sum(Ai * Wi), i = 0, ... , 16 ���ȶ�ǰ17λ���ֵ�Ȩ��� 
     * Ai:��ʾ��iλ���ϵ����֤��������ֵ Wi:��ʾ��iλ���ϵļ�Ȩ���� Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 
     * 2 ��2������ģ Y = mod(S, 11) ��3��ͨ��ģ�õ���Ӧ��У���� Y: 0 1 2 3 4 5 6 7 8 9 10 У����: 1 0 
     * X 9 8 7 6 5 4 3 2 
     */  
  
    /** 
     * ���ܣ����֤����Ч��֤ 
     * @param IDStr ���֤�� 
     * @return ��Ч������"" ��Ч������String��Ϣ 
     * @throws NumberFormatException  
     * @throws ParseException 
     */  
    @SuppressWarnings("unchecked")  
    private static String idCardValidate(String IDStr) throws ParseException {  
        String errorInfo = "";// ��¼������Ϣ  
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",  
                "3", "2" };  
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",  
                "9", "10", "5", "8", "4", "2" };  
        String Ai = "";  
        // ================ ����ĳ��� 15λ��18λ ================  
        if (IDStr.length() != 15 && IDStr.length() != 18) {  
            errorInfo = "���֤���볤��Ӧ��Ϊ15λ��18λ��";  
            return errorInfo;  
        }  
        // =======================(end)========================  
  
        // ================ ���� �������Ϊ��Ϊ���� ================  
        if (IDStr.length() == 18) {  
            Ai = IDStr.substring(0, 17);  
        } else if (IDStr.length() == 15) {  
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);  
        }  
        if (isNumeric(Ai) == false) {  
            errorInfo = "���֤15λ���붼ӦΪ���� ; 18λ��������һλ�⣬��ӦΪ���֡�";  
            return errorInfo;  
        }  
        // =======================(end)========================  
  
        // ================ ���������Ƿ���Ч ================  
        String strYear = Ai.substring(6, 10);// ���  
        String strMonth = Ai.substring(10, 12);// �·�  
        String strDay = Ai.substring(12, 14);// �·�  
        if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {  
            errorInfo = "���֤������Ч��";  
            return errorInfo;  
        }  
        GregorianCalendar gc = new GregorianCalendar();  
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");  
        if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150  
                || (gc.getTime().getTime() - s.parse(  
                        strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {  
            errorInfo = "���֤���ղ�����Ч��Χ��";  
            return errorInfo;  
        }  
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {  
            errorInfo = "���֤�·���Ч";  
            return errorInfo;  
        }  
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {  
            errorInfo = "���֤������Ч";  
            return errorInfo;  
        }  
        // =====================(end)=====================  
  
        // ================ ������ʱ����Ч ================  
        Hashtable h = GetAreaCode();  
        if (h.get(Ai.substring(0, 2)) == null) {  
            errorInfo = "���֤�����������";  
            return errorInfo;  
        }  
        // ==============================================  
  
        // ================ �ж����һλ��ֵ ================  
        int TotalmulAiWi = 0;  
        for (int i = 0; i < 17; i++) {  
            TotalmulAiWi = TotalmulAiWi  
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))  
                    * Integer.parseInt(Wi[i]);  
        }  
        int modValue = TotalmulAiWi % 11;  
        String strVerifyCode = ValCodeArr[modValue];  
        Ai = Ai + strVerifyCode;  
  
        if (IDStr.length() == 18) {  
            if (Ai.equals(IDStr) == false) {  
                errorInfo = "���֤��Ч�����ǺϷ������֤����";  
                return errorInfo;  
            }  
        } else {  
            return "";  
        }  
        // =====================(end)=====================  
        return "";  
    }  
  
    /** 
     * ���ܣ����õ������� 
     * @return Hashtable ���� 
     */  
    @SuppressWarnings("unchecked")  
    private static Hashtable GetAreaCode() {  
        Hashtable hashtable = new Hashtable();  
        hashtable.put("11", "����");  
        hashtable.put("12", "���");  
        hashtable.put("13", "�ӱ�");  
        hashtable.put("14", "ɽ��");  
        hashtable.put("15", "���ɹ�");  
        hashtable.put("21", "����");  
        hashtable.put("22", "����");  
        hashtable.put("23", "������");  
        hashtable.put("31", "�Ϻ�");  
        hashtable.put("32", "����");  
        hashtable.put("33", "�㽭");  
        hashtable.put("34", "����");  
        hashtable.put("35", "����");  
        hashtable.put("36", "����");  
        hashtable.put("37", "ɽ��");  
        hashtable.put("41", "����");  
        hashtable.put("42", "����");  
        hashtable.put("43", "����");  
        hashtable.put("44", "�㶫");  
        hashtable.put("45", "����");  
        hashtable.put("46", "����");  
        hashtable.put("50", "����");  
        hashtable.put("51", "�Ĵ�");  
        hashtable.put("52", "����");  
        hashtable.put("53", "����");  
        hashtable.put("54", "����");  
        hashtable.put("61", "����");  
        hashtable.put("62", "����");  
        hashtable.put("63", "�ຣ");  
        hashtable.put("64", "����");  
        hashtable.put("65", "�½�");  
        hashtable.put("71", "̨��");  
        hashtable.put("81", "���");  
        hashtable.put("82", "����");  
        hashtable.put("91", "����");  
        return hashtable;  
    }  
  
    /** 
     * ���ܣ��ж��ַ����Ƿ�Ϊ���� 
     * @param str 
     * @return 
     */  
    private static boolean isNumeric(String str) {  
        Pattern pattern = Pattern.compile("[0-9]*");  
        Matcher isNum = pattern.matcher(str);  
        if (isNum.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    /** 
     * ���ܣ��ж��ַ����Ƿ�Ϊ���ڸ�ʽ 
     * @param str 
     * @return 
     */  
    public static boolean isDate(String strDate) {  
        Pattern pattern = Pattern  
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");  
        Matcher m = pattern.matcher(strDate);  
        if (m.matches()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
}  