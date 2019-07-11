package com.terena.xust.shootgame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 登录窗口类
 * 功能：输入用户名和密码
 * 按钮：
 *    登录-验证用户名和密码是否匹配
 *    取消-退出
 *    注册-新用户添加到用户表中
 */

public class LoginJFrame extends JFrame{

    public static String curName;
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;  // 屏幕的宽
    public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;  // 屏幕的高
    public static final int WIDTH = 300;  // 窗口的宽
    public static final int HEIGHT = 220;  // 窗口的高
    public static int jFrameX = width / 2 - WIDTH / 2;  // 水平居中x坐标
    public static int jFrameY = height / 2 - HEIGHT / 2;  // 垂直居中y坐标

    private JFrame jFrame = new JFrame("LOGIN");
    private Container c = jFrame.getContentPane();
    private JLabel a1 = new JLabel("User");
    private JTextField username = new JTextField();
    private JLabel a2 = new JLabel("Key");
    private JPasswordField password = new JPasswordField();
    private JButton okbtn = new JButton("OK");
    private JButton cancelbtn = new JButton("Cancel");
    private JButton registerbtn = new JButton("Register");

    public LoginJFrame() {
        //设置窗体的位置及大小
        jFrame.setBounds(jFrameX, jFrameY, WIDTH, HEIGHT);
        //设置一层相当于桌布的东西
        c.setLayout(new BorderLayout());//布局管理器
        //设置按下右上角X号后关闭
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //初始化-往窗体里放其他控件
        initialLogin();
        // 初始化-给按钮添加监听器
        listerner();
        //设置窗体可见
        jFrame.setVisible(true);

    }

    public void initialLogin() {
        /*标题部分--North*/
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.add(new JLabel("ShootGame Login"));
        c.add(titlePanel, "North");

        /*输入部分--Center*/
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(null);
        a1.setBounds(50, 20, 50, 20);
        a2.setBounds(50, 60, 50, 20);
        fieldPanel.add(a1);
        fieldPanel.add(a2);
        username.setBounds(110, 20, 120, 20);
        password.setBounds(110, 60, 120, 20);
        fieldPanel.add(username);
        fieldPanel.add(password);
        c.add(fieldPanel, "Center");

        /*按钮部分--South*/
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(okbtn);
        buttonPanel.add(registerbtn);
        buttonPanel.add(cancelbtn);
        c.add(buttonPanel, "South");
    }

    public void listerner () {
        //确认按下去获取
        okbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = username.getText();
                String pwd = String.valueOf(password.getPassword());

                // 如果存在验证用户名和密码是否匹配
                try {
                    if(UserDao.checkUserNameSame(uname)) {
                        if (UserDao.isMatch(uname, pwd)) {  // 用户名和密码匹配
                            // 销毁当前界面
                            jFrame.dispose();
                            curName = uname;
                            // 进入游戏界面
                            ShootGameJPanel.initialGame();
                        } else {
                            // 弹出提示框-密码错误，请重新输入
                            JOptionPane.showMessageDialog(null, "Password error, please input again!");
//                            System.out.println("false");
                        }
                    } else {  // 数据库中没有这个用户
                        // 弹出提示框-用户不存在，请先注册
//                        System.out.println("please regist");
                        JOptionPane.showMessageDialog(null, "Username is not registered, please regist first!");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //取消按下去清空
        cancelbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });

        // 注册
        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 检验用户名是否存在
                String uname = username.getText();
                String pwd = String.valueOf(password.getPassword());
                try {
                    boolean isSame = UserDao.checkUserNameSame(uname);
                    if(isSame == true) {
                        // System.out.println("username has existed");
                        // 弹出消息框--用户名已存在，请直接登录
                        JOptionPane.showMessageDialog(null, "Username has existed, please log in!");
                    } else {
                        // 不重复则保存用户
                        UserDao.saveUser(uname, pwd);
                        // 弹出消息框--注册成功请登录
                        JOptionPane.showMessageDialog(null, "Regist succeed, please log in!");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
