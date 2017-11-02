package com.chenyue;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListEmp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
//		out.println("<!doctype html>                                                                                                                                                                ");
//		out.println("<html>                                                                                                                                                                         ");
//		out.println("<head>                                                                                                                                                                         ");
//		out.println("    <meta charset='UTF-8'>                                                                                                                                                     ");
//		out.println("    <title>��̨����</title>                                                                                                                                                        ");
//		out.println("    <link rel='stylesheet' type='text/css' href='css/common.css'/>                                                                                                             ");
//		out.println("    <link rel='stylesheet' type='text/css' href='css/main.css'/>                                                                                                               ");
//		out.println("    <script type='text/javascript' src='js/libs/modernizr.min.js'></script>                                                                                                    ");
//		out.println("</head>                                                                                                                                                                        ");
//		out.println("<body>                                                                                                                                                                         ");
//		out.println("<div class='topbar-wrap white'>                                                                                                                                                ");
//		out.println("    <div class='topbar-inner clearfix'>                                                                                                                                        ");
//		out.println("        <div class='topbar-logo-wrap clearfix'>                                                                                                                                ");
//		out.println("            <h1 class='topbar-logo none'><a href='index.html' class='navbar-brand'>��̨����</a></h1>                                                                               ");
//		out.println("            <ul class='navbar-list clearfix'>                                                                                                                                  ");
//		out.println("                <li><a class='on' href='index.html'>��ҳ</a></li>                                                                                                                ");
//		out.println("                <li><a href='#' target='_blank'>��վ��ҳ</a></li>                                                                                                                  ");
//		out.println("            </ul>                                                                                                                                                              ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("        <div class='top-info-wrap'>                                                                                                                                            ");
//		out.println("            <ul class='top-info-list clearfix'>                                                                                                                                ");
//		out.println("                <li><a href='http://www.jscss.me'>����Ա</a></li>                                                                                                                 ");
//		out.println("                <li><a href='http://www.jscss.me'>�޸�����</a></li>                                                                                                                ");
//		out.println("                <li><a href='http://www.jscss.me'>�˳�</a></li>                                                                                                                  ");
//		out.println("            </ul>                                                                                                                                                              ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("    </div>                                                                                                                                                                     ");
//		out.println("</div>                                                                                                                                                                         ");
//		out.println("<div class='container clearfix'>                                                                                                                                               ");
//		out.println("    <div class='sidebar-wrap'>                                                                                                                                                 ");
//		out.println("        <div class='sidebar-title'>                                                                                                                                            ");
//		out.println("            <h1>�˵�</h1>                                                                                                                                                        ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("        <div class='sidebar-content'>                                                                                                                                          ");
//		out.println("            <ul class='sidebar-list'>                                                                                                                                          ");
//		out.println("                <li>                                                                                                                                                           ");
//		out.println("                    <a href='#'><i class='icon-font'>&#xe003;</i>���ò���</a>                                                                                                      ");
//		out.println("                    <ul class='sub-menu'>                                                                                                                                      ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe008;</i>��Ʒ����</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe005;</i>���Ĺ���</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe006;</i>�������</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe004;</i>���Թ���</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe012;</i>���۹���</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe052;</i>��������</a></li>                                                                               ");
//		out.println("                        <li><a href='design.html'><i class='icon-font'>&#xe033;</i>������</a></li>                                                                               ");
//		out.println("                    </ul>                                                                                                                                                      ");
//		out.println("                </li>                                                                                                                                                          ");
//		out.println("                <li>                                                                                                                                                           ");
//		out.println("                    <a href='#'><i class='icon-font'>&#xe018;</i>ϵͳ����</a>                                                                                                      ");
//		out.println("                    <ul class='sub-menu'>                                                                                                                                      ");
//		out.println("                        <li><a href='system.html'><i class='icon-font'>&#xe017;</i>ϵͳ����</a></li>                                                                               ");
//		out.println("                        <li><a href='system.html'><i class='icon-font'>&#xe037;</i>��������</a></li>                                                                               ");
//		out.println("                        <li><a href='system.html'><i class='icon-font'>&#xe046;</i>���ݱ���</a></li>                                                                               ");
//		out.println("                        <li><a href='system.html'><i class='icon-font'>&#xe045;</i>���ݻ�ԭ</a></li>                                                                               ");
//		out.println("                    </ul>                                                                                                                                                      ");
//		out.println("                </li>                                                                                                                                                          ");
//		out.println("            </ul>                                                                                                                                                              ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("    </div>                                                                                                                                                                     ");
//		out.println("    <!--/sidebar-->                                                                                                                                                            ");
//		out.println("    <div class='main-wrap'>                                                                                                                                                    ");
//        out.println("                                                                                                                                                                               ");
//		out.println("        <div class='crumb-wrap'>                                                                                                                                               ");
//		out.println("            <div class='crumb-list'><i class='icon-font'>��</i><a href='/jscss/admin'>��ҳ</a><span class='crumb-step'>&gt;</span><span class='crumb-name'>��Ʒ����</span></div>      ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("        <div class='search-wrap'>                                                                                                                                              ");
//		out.println("            <div class='search-content'>                                                                                                                                       ");
//		out.println("                <form action='/jscss/admin/design/index' method='post'>                                                                                                        ");
//		out.println("                    <table class='search-tab'>                                                                                                                                 ");
//		out.println("                        <tr>                                                                                                                                                   ");
//		out.println("                            <th width='120'>ѡ�����:</th>                                                                                                                         ");
//		out.println("                            <td>                                                                                                                                               ");
//		out.println("                                <select name='search-sort' id=''>                                                                                                              ");
//		out.println("                                    <option value=''>ȫ��</option>                                                                                                               ");
//		out.println("                                    <option value='19'>��Ʒ����</option><option value='20'>�Ƽ�����</option>                                                                           ");
//		out.println("                                </select>                                                                                                                                      ");
//		out.println("                            </td>                                                                                                                                              ");
//		out.println("                            <th width='70'>�ؼ���:</th>                                                                                                                           ");
//		out.println("                            <td><input class='common-text' placeholder='�ؼ���' name='keywords' value='' id='' type='text'></td>                                                  ");
//		out.println("                            <td><input class='btn btn-primary btn2' name='sub' value='��ѯ' type='submit'></td>                                                                  ");
//		out.println("                        </tr>                                                                                                                                                  ");
//		out.println("                    </table>                                                                                                                                                   ");
//		out.println("                </form>                                                                                                                                                        ");
//		out.println("            </div>                                                                                                                                                             ");
//		out.println("        </div>                                                                                                                                                                 ");
//		out.println("        <div class='result-wrap'>                                                                                                                                              ");
//		out.println("            <form name='myform' id='myform' method='post'>                                                                                                                     ");
//		out.println("                <div class='result-title'>                                                                                                                                     ");
//		out.println("                    <div class='result-list'>                                                                                                                                  ");
//		out.println("                        <a href='insert.html'><i class='icon-font'>��</i>������Ʒ</a>                                                                                               ");
//		out.println("                        <a id='batchDel' href='javascript:void(0)'><i class='icon-font'>��</i>����ɾ��</a>                                                                          ");
//		out.println("                        <a id='updateOrd' href='javascript:void(0)'><i class='icon-font'>��</i>��������</a>                                                                         ");
//		out.println("                    </div>                                                                                                                                                     ");
//		out.println("                </div>                                                                                                                                                         ");
//		out.println("                <div class='result-content'>                                                                                                                                   ");
//		out.println("                    <table class='result-tab' width='100%'>                                                                                                                    ");
//		out.println("                        <tr>                                                                                                                                                   ");
//		out.println("                            <th class='tc' width='5%'><input class='allChoose' name='' type='checkbox'></th>                                                                   ");
//		out.println("                            <th>����</th>                                                                                                                                        ");
//		out.println("                            <th>ID</th>                                                                                                                                        ");
//		out.println("                            <th>Ա������</th>                                                                                                                                      ");
//		out.println("                            <th>��ְʱ��</th>                                                                                                                                      ");
//		out.println("                            <th>нˮ</th>                                                                                                                                        ");
//		out.println("                            <th>����</th>                                                                                                                                        ");
//		out.println("                        </tr>                                                                                                                                                  ");
//		
//		
        

		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//System.out.println(req.getContextPath());
		//InputStream in = getClass().getResourceAsStream("/DBconfig.properties");
		InputStream in  = this.getClass().getClassLoader().getResourceAsStream("DBconfig.properties"); 

		Properties properties = new Properties();
		properties.load(in);
		
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String DBUsername = properties.getProperty("DBUsername");
		String DBPassword = properties.getProperty("DBPassword");
		//System.out.println("driver="+driver+"\nurl="+url+"\nDBUsername="+DBUsername+"\nDBPassword="+DBPassword);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,DBUsername,DBPassword);
			String sql = "select empno,ename,hiredate,sal from emp order by sal as desc" ;
					//" where username=? and password=?";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				
				out.println("                        <tr>                                                                                                                                                   ");
				out.println("                            <td class='tc'><input name='id[]' value='59' type='checkbox'></td>                                                                                 ");
				out.println("                            <td>                                                                                                                                               ");
				out.println("                                <input name='ids[]' value='59' type='hidden'>                                                                                                  ");
				out.println("                                <input class='common-input sort-input' name='ord[]' value='0' type='text'>                                                                     ");
				out.println("                            </td>                                                                                                                                              ");
				out.println("                            <td>"+empno+"</td>                                                                                                                                        ");
				out.println("                            <td title='���羭��'><a target='_blank' href='#' title='���羭��'>"+ename+"</a> ��                                                                               ");
				out.println("                            </td>                                                                                                                                              ");
				out.println("                            <td>"+hiredate+"</td>                                                                                                                                         ");
				out.println("                            <td>"+sal+"</td>                                                                                                                                     ");
				out.println("                            <td>                                                                                                                                               ");
				out.println("                                <a class='link-update' href='#'>�޸�</a>                                                                                                         ");
				out.println("                                <a class='link-del' href='#'>ɾ��</a>                                                                                                            ");
				out.println("                            </td>                                                                                                                                              ");
				out.println("                        </tr>                                                                                                                                                  ");

				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		out.println("                                                                                                                                                                               ");
		out.println("                    </table>                                                                                                                                                   ");
		out.println("                    <div class='list-page'> 2 �� 1/1 ҳ</div>                                                                                                                    ");
		out.println("                </div>                                                                                                                                                         ");
		out.println("            </form>                                                                                                                                                            ");
		out.println("        </div>                                                                                                                                                                 ");
		out.println("    </div>                                                                                                                                                                     ");
		out.println("    <!--/main-->                                                                                                                                                               ");
		out.println("</div>						");
		out.println("</body>					");
		out.println("</html>					");
		

	}
}