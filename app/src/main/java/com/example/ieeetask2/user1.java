package com.example.ieeetask2;

public class user1 {
        private int id ;
        private String name;
        private String email;
        private String phone;
        private String pass;

        public user1( String name, String email, String phone,String pass) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.pass = pass;
        }

        public user1(int id , String name, String email,String phone, String pass) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.pass = pass;
        }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

}
