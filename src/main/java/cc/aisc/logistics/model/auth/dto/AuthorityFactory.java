package cc.aisc.logistics.model.auth.dto;


import cc.aisc.logistics.model.auth.Permission;

import java.util.*;

/**
 * Created by sjf on 16-7-6.
 */
public class AuthorityFactory {
    public AuthorityFactory() {
    }
    public static Authority getAuthority(Permission perm){
        return new Authority(
                perm.getResource().toString(),
                mapPermToMode(perm.getPermission())
        );
    }

    private static String[] mapPermToMode(Integer perms){
        List<String> mode = new ArrayList<String>();
        mode.add("NONE");
        mode.add("EXEC");
        mode.add("GRANT");
        switch (perms){
            case 1:
                mode.remove(1);
                mode.remove(2);
                break;
            case 2:
                mode.remove(0);
                mode.remove(2);
                break;
            case 3:
                mode.remove(0);
                break;
            default:
                mode.remove(1);
                mode.remove(2);
                break;
        }
        return (String[])mode.toArray();
    }
}
