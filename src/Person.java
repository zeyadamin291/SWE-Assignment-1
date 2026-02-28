
public class Person {
    private String
            national_ID,
            name,
            Phone_number,
            Personal_email ,
            address;

    public void setNational_ID(String national_ID) {
        this.national_ID = national_ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    public void setPersonal_email(String personal_email) {
        Personal_email = personal_email;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public  String getNational_ID(){
        return national_ID;
    }

    public String getAddress() {
        return address;
    }

    public String getPersonal_email() {
        return Personal_email;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public boolean isValid_National_ID(String national_ID){
        return national_ID.length() == 14;
    }

    public boolean isValid_name (String name) {
        int cnt = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                cnt++;
            }
        }
        return cnt >= 3;
    }

    public boolean isValid_phone(String phone_number){
        boolean flag;
        flag = phone_number.substring(0 , 1) == "01" && phone_number.charAt(2) == '0' || phone_number.charAt(2) == '1'
        || phone_number.charAt(2)== '2' || phone_number.charAt(2) == '5';
        return flag && phone_number.length() == 11;
    }

    public boolean isValid_email(String email){
        return email.substring(email.length() - 10).equals("@gmail.com");
    }
}
