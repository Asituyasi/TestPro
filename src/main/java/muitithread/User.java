package muitithread;

import java.util.Objects;

/**
 * desc :
 * Created by tiantian on 2018/8/23
 */
public class User {
    private int id;
    private int code;

    public User() {
        this.id = 0;
        this.code = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                code == user.code;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, code);
    }
}
