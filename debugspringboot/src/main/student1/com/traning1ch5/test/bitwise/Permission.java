package com.traning1ch5.test.bitwise;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class Permission {

    public static final int ADD = 1;//添加
    public static final int DELETE = 1 << 1;//添加
    public static final int UPDATE = 1 << 2;//添加
    public static final int SELECT = 1 << 3;//添加

    private int flag;

    public void setPermission(int flag) {
        this.flag = flag;
    }

    public void setEnable(int per) {
        flag = flag | per;
    }

    public void setDisable(int per) {
        flag = flag & ~per;
    }

    public boolean allow(int per) {
        return ((flag & per) == per);
    }

    public boolean notallow(int per) {
        return ((flag & per) == 0);
    }

    public static void main(String[] args) {
        int flag = 0;
        Permission permission = new Permission();
        permission.setPermission(flag);

        permission.setDisable(Permission.UPDATE | Permission.DELETE);
        permission.setEnable(Permission.ADD | Permission.SELECT);
        System.out.println(permission.allow(Permission.ADD));
        System.out.println(permission.allow(Permission.DELETE));
        System.out.println(permission.allow(Permission.UPDATE));
        System.out.println(permission.allow(Permission.SELECT));
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println(permission.notallow(Permission.UPDATE | Permission.ADD));
    }
}
