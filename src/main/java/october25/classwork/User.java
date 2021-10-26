package october25.classwork;

import java.util.Arrays;

public class User {
    private int id;
    private String username;
    private String password;
    private Role[] roles;

    public User(int id, String username, String password, Role[] roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }


    public Role[] getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id = ").append(id).append("\n")
                .append("username = ").append(username).append("\n")
                .append("password = ").append(password).append("\n")
                .append("roles = [");
        for (Role role : roles) {
            sb.append(role.toString()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }
}
