class UserProfile{
    private String uname;
    private String email;
    private String password;
    public String getName(){
        return uname;
    }
    public void setName(String uname){
         if (uname == null || uname.isEmpty()) {
            System.out.println("Username cannot be empty");
        }
        this.uname = uname;
    }

     public String getMail(){
        return email;
    }
     public void setMail(String email){
        this.email=email;
    }
   public String getPassword(){
        return password;
    }
     public void setPassword(String password){
        if (password == null || password.length() < 8) {
            System.out.println("Password must be at least 8 characters long");
        } 
        else {
            this.password = password;
        }
    }


    public static void main(String args[]){
        UserProfile p1=new UserProfile();
        p1.setName("Harika");
        p1.setMail("harika@gmail.com");
        p1.setPassword("wetewwrudf");
        System.out.println("Name: " + p1.getName());
        System.out.println("Email: " + p1.getMail());
        System.out.println("Password: " + p1.getPassword());
    }
        
}



