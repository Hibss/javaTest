package com.syz.java.test.hashCode;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author steven.sheng
 * @Date 2018/11/26/026.
 */
@Builder
public class User implements Serializable{

    private static final long serialVersionUID = -8126485625965560879L;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String addr;

    @Getter
    @Setter
    private Integer id;

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
