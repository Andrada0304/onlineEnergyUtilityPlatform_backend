package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "birth_date", length = 45)
    private String birthDate;

    @Column(name = "address")
    private String address;

    /* @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "username")
        private Account account;
    */
   @Column(name = "username", unique = true, nullable = false)
   private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles userRole;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
    private List<Device> devices = new ArrayList<>();


    public Client(){

    }

    public Client(String name , String birthDate, String address){
        this.name=name;
        this.birthDate = birthDate;
        this.address=address;
    }

    public Client(UUID id,String name ,String birthDate, String address,String username,String password,List<Device> devices){
        this.id=id;
        this.name=name;
        this.birthDate = birthDate;
        this.address=address;
        //this.account=account;
        this.username=username;
        this.password = password;
        this.userRole = Roles.CLIENT;
        this.devices=devices;
    }
    public Client(String name ,String birthDate, String address,String username,String password,List<Device> devices){
        this.name=name;
        this.birthDate = birthDate;
        this.address=address;
        this.username=username;
        this.password = password;
        this.userRole =Roles.CLIENT;
        this.devices=null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getUserRole() {
        return userRole;
    }

    public void setUserRole(Roles userRole) {
        this.userRole = userRole;
    }

}
