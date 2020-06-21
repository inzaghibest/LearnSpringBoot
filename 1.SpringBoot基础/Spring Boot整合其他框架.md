# Spring Boot整合其他框架

## 一. Web开发

### 1.1 静态资源访问

在我们开发Web应用的时候，需要引用大量的js,css,图片等静态资源。

默认配置：

Spring Boot默认提供静态资源目录位置需要置于classpath下,目录名需符合如下规则：

- /static
- /public
- /resources
- /META-INF/resources

举例：我们可以在src/main/resources/目录下创建static,在该位置放置一个图片文件。启动程序后，尝试访问http://localhost:8080/D.jpg.如能显示图片，配置成功。

**注意**: 上述目录都是用根路径/ + 资源名称即可访问，不需要在路径中加/static等。但是如果再/static下建立新的文件夹，需要用/newfiles/资源名访问。

### 1.2 渲染Web页面

**渲染web页面**

在之前的示例中，我们都是通过@RestController来处理请求，所以返回的内容为json对象。那么如果需要渲染html页面的时候，要如何实现呢？

**模板引擎**

在动态HTML实现上Spring Boot依然可以完美胜任，并且提供了多种模板引擎的默认配置支持，所以在推荐的模板引擎下，我们可以很快的上手开发动态网站。

Spring Boot提供了默认配置的模板引擎主要有以下几种：

- Thymeleaf
- FreeMarker
- Velocity
- Groovy
- Mustache

Spring Boot建议使用这些模板引擎，避免使用JSP，若一定要使用JSP将无法实现Spring Boot的多种特性，具体可见后文：支持JSP配置。

当然你使用上述模板引擎中的任何一个，他们默认的模板配置路径为:src/main/resources/templates。当然也可以修改这个路径，具体如何修改，可在后续各模板引擎的配置属性中查询并修改。