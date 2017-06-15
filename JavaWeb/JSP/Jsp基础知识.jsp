Jsp page指令：
<%@ page 属性1="属性值" ... %>
Jsp include指令：
<%@ include file="URL" %>
include动作：
<jsp:include page="URL" flush="true|false"/>
include指令与include动作的区别：
1.语法格式
include指令：<%@ include file=".." %>     
include动作：<jsp:include page="..">
2.发生作用的时间
include指令：页面转换期间
include动作：请求期间
3.包含的内容
include指令：文件的实际内容
include动作：页面的输出
4.转换成的servlet
include指令：主页面和包含页面转换为一个servlet
include动作：主页面和包含页面转换为独立的servlet
5.编译时间
include指令：较慢-资源必须被解析
include动作：较快
6.执行时间
include指令：稍快
include动作：较慢-每次资源必须被解析
Jsp注释：
①<!-- HTML注释，客户端可见 -->
②<%-- Jsp注释，客户端不可见 --%>
③<% //单行注释  
/*多行注释*/ %>
Jsp脚本：
<% Java代码; %>
Jsp声明：
<%! Java代码; %>
Jsp表达式：
<%=表达式 %>
Jsp内置对象：
一、out对象
out对象是JspWriter类的实例，是向客户端输出内容常用的对象。
常用方法：
1.void println();向客户端打印字符串
2.void clear();清除缓冲区的内容，如果在flush()之后调用会抛出异常
3.void clearBuffer();清除缓冲区的内容，如果在flush()之后调用不会抛出异常
4.void flush();将缓冲区的内容输出到客户端
5.int getBufferSize();返回缓冲区以字节数的大小，如果不设缓冲区则为0
6.int getRemaining();返回缓冲区还剩多少可用
7.boolean isAutoFlush();返回缓冲区满时，是自动清空还是抛出异常
8.void close();关闭输出流
二、request对象
客户端请求的信息被封装在request对象中，通过它才能了解到客户端的需求，然后做出响应。它是httpServletRequest类的实例。request对象具有请求域，即完成客户端的请求之前，该对象一直有效。
常用方法：
1.String getParameter(String name);返回name指定参数的参数值
2.String[] getParameterValues(String name);返回包含参数name的所有值的数组
3.void setAttribute(String,Object);存储此请求中的属性
4.object getAttribute(String name);返回指定属性的属性值
5.String getContentType();得到请求体的MIME类型
6.String getProtocol();返回请求用的协议类型及版本号
7.String getServerName();返回接收请求的服务器主机名
8.int getServerPort();返回服务器接收此请求所用的端口号
9.String getCharacterEncoding();返回字符编码方式
10.void getCharacterEncoding();设置请求的字符编码方式
11.int getContentLength();返回请求体的长度（以字节数）
12.String getRemoteAddr();返回发送此请求的客户端IP地址
13.String getRealPath(String path);返回一虚拟路径的真实路径
14.String request.getContextPath();返回上下文路径
15.void request.setCharacterEncoding(String name);设置request的字符集编码
三、response对象
response对象包含了响应客户端的有关信息，但在Jsp中很少直接用到它。它是HttpServletResponse类的实例。response对象具有页面作用域，即访问一个页面时该页面内的response对象只能对这次访问有效，其他页面的response对象对当前页面无效。
常用方法：
1.String getCharacterEncoding();返回响应用的是何种字符编码
2.void setContentType(String type);设置响应的MIME类型
3.PrintWriter getWriter();返回可以向客户端输出字符的一个对象
4.void sendRedirect(java.lang.String location);重新定向客户端的请求
四、session对象
session对象是一个Jsp内置对象，在第一个Jsp页面被装载时自动创建，完成会话期的管理。从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离开这个服务器结束，被称为一个会话。当一个客户访问一个服务器时，可能会在服务器的几个页面之间切换，服务器应当通过某种办法知道这是一个客户，就需要session对象。session对象HttpSession类的实例。
常用方法：
1.long getCreationTime();返回SESSION创建的时间
2.public String getId();返回SESSION创建时Jsp引擎为它设的唯一ID号
3.public Object setAttribute(String name, Object value);使用指定名称将对象绑定到此会话
4.public Object getAtrtribute(String name);返回与此会话中的指定名称绑定在一起的对象，如果没有对象绑定在该名称下，则返回null
5.String[] getValueNames();返回一个包含此SESSION中左右可用属性的数组
6.int getMaxInactiveInterval();返回两次请求间隔多长时间此SESSION被取消（单位秒）
Session的销毁有三种方式：1、调用session.invalidate()方法；2、Session过期（超时）；3、服务器重新启动；
设置Session超时时间有两种方法：
1、session.setMaxInactiveInterval(时间);(单位秒)
2、在web.xml配置
<session-config>
	<session-timeout>10</session-timeout>
</session-config>
五、application对象
application对象实现了用户间的数据的共享，可存放全局变量。application开始于服务器的启动，终止于服务器的关闭。在用户的前后连接或不同用户之间的连接中，可以对application对象的同一属性进行操作。在任何地方对application对象属性的操作，都将影响到其他用户对此的访问。application对象时ServletContext类的实例。
常用方法：
1.public void setAttribute(String name, Object value);使用指定名称将对象绑定到此会话。
2.public Object getAttribute(String name);返回与此对话中的指定名称绑定在一起的对象，如果没有对象绑定在该名称下，则返回null。
3.Enumeration getAttributeNames();返回所有可用属性名的枚举。
4.String getServerInfo();返回Jsp(SERVLET)引擎名及版本号。
六、page对象
page对象就是指向当前Jsp页面本身，有点像类中的this指针，它是java.lang.Object类的实例。
常用方法：
1.class getClass();返回此Object的类
2.int hashCode();返回此Object的hash码
3.boolean equals(Object obj);判断此Object是否与指定的Object对象相等
4.void copy(Object obj);把此Object拷贝到指定的Object对象中
5.Object clone();克隆此Object对象
6.String toString();把此Object对象转换成String类的对象
7.void notify();唤醒一个等待的线程
8.void notifyAll();唤醒所有等待的线程
9.void wait(int timeout);使一个线程处于等待直到timeout结束或被唤醒
10.void wait();使一个线程处于等待直到被唤醒
七、pageContext对象
pageContext对象提供了对Jsp页面内所有对象以及名字空间的访问。pageContext对象可以访问到本页所在的session，也可以取本页面所在的application的某一属性值。pageContext对象的本类名也叫pageContext。
常用方法：
1.JspWriter getOut();返回当前客户端响应被使用的JspWriter流（out）
2.HttpSession getSession();返回当前页中的HttpSession对象（session）
3.Object getPage();返回当前页面的Object对象（page）
4.ServletRequest getRequest();返回当前页的ServletRequest对象（request）
5.SerletResponse getResponse();返回当前页的ServletResponse对象（response）
6.void setAttribute(String name, Object attribute);设置属性及属性值
7.Object getAttribute(String name, int scope);返回指定范围内取属性的值
8.int getAttributeScope(String name);返回某属性的作用范围
9.void forward(String relativeUrlPath);使当前页面重导到另一页面
10.void include(String relativeUrlPath);在当前位置包含另一文件
八、Config对象
config对象是在一个Servlet初始化时，Jsp引擎向它传递信息用的，此信息包括Servlet初始化时所要用到的参数（通过属性名和属性值构成）以及服务器的有关信息（通过传递一个ServletContext对象）
常用方法：
1.ServletContext getServletContext();返回含有服务器相关信息的ServletContext对象
2.String getInitParamter(String name);返回初始化参数的值
3.Enumeration getInitParameterNames();返回Servlet初始化所需所有参数的枚举
九、Exception对象
exception对象是一个异常对象，当一个页面在运行时过程中发生了异常，就产生这个对象。如果一个Jsp页面要应用此对象，就必须把isErrorPage设为true，否则无法编译。他实际上是java.lang.Throwable的对象。
常用方法：
1.String getMessage();返回描述异常的消息
2.String toString();返回关于异常的简短描述消息
3.void printStackTrace();显示异常以及其栈轨迹
4.Throwable FillInStackTrace();重写异常的执行栈轨迹

Javabean
设计原则：公有类，无参的构造方法，属性私有，getter和setter方法。
Jsp动作元素：
动作元素为请求处理阶段提供信息。动作元素遵循XML元素的语法，有一个包含元素名的开始标签，可以有属性、可选的内容、与开始标签匹配的结束标签。
1、与存取JavaBean有关的，包括：
<jsp:useBean><jsp:setProperty><jsp:getProperty>
2、Jsp1.2开始有的基本元素，包括六个动作元素：
<jsp:include><jsp:forward><jsp:param><jsp:plugin><jsp:params><jsp:fallback>
3、Jsp2.0新增加的元素，主要与Jsp Document有关，包括六个元素：
<jsp:root><jsp:declaration><jsp:scriptlet><jsp:expression><jsp:text><jsp:output>
4、Jsp2.0新增的动作元素，主要是用来动态生成XML元素标签的值，包括三个动作：
<jsp:attribute><jsp:body><jsp:element>
5、Jsp2.0新增的动作元素，主要是用在Tag File中，有两个元素：
<jsp:invoke><jsp:dobody>
动作元素详解：
<jsp:useBean id = "实例名" class = "Java类名" scope = "作用范围" />
//作用范围：page,仅在当前页面有效; request,可以通过HttpRequest.getAttribute()方法取得JavaBean对象; session,可以通过HttpSession.getAttribute()方法取得JavaBean对象; application,可以通过application.getAttribute()方法取得JavaBean对象；
<jsp:setProperty name = "JavaBean实例名" property = "*" /> //跟表单关联
<jsp:setProperty name = "JavaBean实例名" property = "JavaBean属性名" /> //跟表单相关
<jsp:setProperty name = "JavaBean实例名" property = "JavaBean属性名" value = "BeanValue" /> //手工设置
<jsp:setProperty name = "JavaBean实例名" property = "propertyName" param = "request对象中的参数名" /> //跟request参数关联
<jsp:getProperty name = "JavaBean实例名" property = "属性名" />
<jsp:include page="URL" flush="true|false"/>
<jsp:forward page="URL" /> //等同于request.getRequestDispatcher("/url").forward(request, response);
<jsp:param name="参数名" value="参数值"/> //常作为jsp:forward动作的子标签使用
Cookie对象
创建Cookie对象：Cookie newCookie = new Cookie(String key, Object value);
写入Cookie对象：response.addCookie(newCookie);
读取Cookie对象：Cookie[] cookie = request.getCookie();
Cookie常用对象：
1.void setMaxAge(int expiry);设置Cookie的有效期，以秒为单位
2.void setValue(String value);在Cookie创建后，对Cookie进行赋值
3.String getName();获取Cookie的名称
4.String getValue();获取Cookie的值
5.int getMaxAge();获取Cookie的有效时间，以秒为单位
Session与Cookie的区别
1.session在服务器端保存用户信息，而cookie在客户端保存用户信息；
2.session中保存的是Object类型，而cookie保存的是String类型；
3.session随会话的结束而将其存储的数据销毁，而cookie可以长期保存在客户端；
4.session保存重要的信息，而cookie保存不重要的信息；