package com.spittr.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
    private Long id;
    @NotNull
    @Size(min=2,max=30,message="{firstname.size}")
    private String firstName;

    @NotNull
    @Size(min=2,max=30,message="{lastname.size}")
    private String lastName;

    @NotNull
    @Size(min=5,max=16,message="{username.size}")
    private String userName;

    @NotNull
    @Size(min=5,max=25,message="{password.size}")
    private String password;

    @NotNull
    @Email(message="{email.valid}")
    private String email;

    public Spitter(){
        this(null,null,null,null,null);
    }

    public Spitter(String firstName,String lastName,String userName,String password){
        this(null,firstName,lastName,userName,password);
    }

    public Spitter(Long id,String firstName,String lastName,String userName,String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.userName=userName;
        this.password=password;
    }

    public Long getId(){return this.id;}
    public void setId(Long id){this.id=id;}

    public String getFirstName(){return this.userName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getLastName(){return this.lastName;}
    public void setLastName(String lastName){this.lastName=lastName;}

    public String getUserName(){return this.userName;}
    public void setUserName(String userName){this.userName=userName;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password=password;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email=email;}
}
