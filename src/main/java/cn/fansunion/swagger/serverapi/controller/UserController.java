package cn.fansunion.swagger.serverapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.collect.Lists;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author lm
 */
@Api(value = "user", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("user")
public class UserController {

	// 列出某个类目的所有规格
	@ApiOperation(value = "获得用户列表by_param", notes = "列表信息by_param", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "get_by_param", method = RequestMethod.POST)
	public Result<User> list(@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
			@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId2,
			@ApiParam(value = "token", required = true) @RequestParam String token) {
		Result<User> result = new Result<User>();
		User user = new User();
		System.out.println(categoryId + "-->" + categoryId2);

		result.setData(user);
		return result;
	}

	@ApiOperation(value = "获得用户列表get_by_vo", notes = "列表信息get_by_vo", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "get_by_vo", method = RequestMethod.POST)
	public Result<User> list_vo(@RequestBody User user) {
		Result<User> result = new Result<User>();
		System.out.println(user.getName() + "<--user-->" + user.getPassword());
		result.setData(user);
		return result;
	}

	@ApiOperation(value = "获得用户列表by_string_json", notes = "列表信息by_string_json", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "get_string_json", method = RequestMethod.POST)
	public Result<User> list_string_json(@ApiParam(value = "分类ID", required = true) @RequestParam String json) {
		Result<User> result = new Result<User>();
		System.out.println(json);
		return result;
	}

	@RequestMapping(value = "get_by_url/{name}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据用户名获取get_by_url", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, notes = "根据用户名获取用户对象")
	public Result<User> list_string_variable(
			@ApiParam(required = true, name = "name", value = "用户名") @PathVariable String name) throws Exception {
		Result<User> result = new Result<User>();
		System.out.println(name);
		return result;
	}

	@ApiOperation(value = "返回类型return_string", notes = "获取商品信息(测试返回的string)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "return_string", method = RequestMethod.POST)
	// @RequestBody只能有1个
	// 使用了@RequestBody，不能在拦截器中，获得流中的数据，再json转换，拦截器中，也不清楚数据的类型，无法转换成java对象
	// 只能手动调用方法
	public String add_return_string(@RequestBody User user) {
		System.out.println("name:" + user.getName());
		return user.getName();
	}

	@ApiOperation(value = "返回类型return_vo", notes = "获取商品信息(测试返回的vo)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "return_vo", method = RequestMethod.POST)
	public User add_return_vo() {
		User user = new User();
		user.setName("vo");
		user.setPassword("password_vo");
		return user;
	}

	@ApiOperation(value = "返回类型return_list_vo", notes = "获取商品信息(测试返回的list_object)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "return_list_vo", method = RequestMethod.POST)
	public List<User> add_return__list_object(@RequestBody User user) {
		List<User> listUser = Lists.newArrayList();
		User user1 = new User();
		user1.setName("vo1");
		user1.setPassword("password_vo2");
		User user2 = new User();
		user2.setName("vo2");
		user2.setPassword("password_vo22");
		listUser.add(user1);
		listUser.add(user2);
		return listUser;
	}

	@ApiOperation(value = "获得用户列表by_request", notes = "列表信息by_request", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "get_by_request", method = RequestMethod.POST)
	public Result<User> list(@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
			@ApiParam(value = "token", required = true) @RequestParam String token, HttpServletRequest request) {
		Result<User> result = new Result<User>();
		User user = new User();
		System.out.println(categoryId + "-->" + categoryId);
		System.out.println();
		result.setData(user);
		return result;
	}

	@ApiOperation(value = "测试废弃的接口", notes = "测试废弃的接口", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@Deprecated
	@ResponseBody
	@RequestMapping(value = "testDeprecated", method = RequestMethod.GET)
	public Result<String> testDeprecated(User user) {
		System.out.println(88 + "testDeprecated");
		return null;
	}

	@ApiOperation(value = "测试请求方法不同的时候", notes = "测试请求方法不同的时候", httpMethod = "POST,DELETE", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "getByPostOrDelete", method = { RequestMethod.POST, RequestMethod.DELETE })
	public Result<String> getByPostOrDelete(@ApiParam(value = "id", required = true) @RequestParam String id) {
		System.out.println(88 + "getByPostOrDelete");
		return null;
	}

	@ApiOperation(value = "获取request中参数", notes = "获取request中参数", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "header", name = "name", dataType = "String", required = true, value = "xingming", defaultValue = "lm"),
			@ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value = "password", defaultValue = "lm") })
	@ApiResponses({ 
			@ApiResponse(code = 200, message = "成功"),
			@ApiResponse(code = 400, message = "请求参数没填好"),
			@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对") })
	@ResponseBody
	@RequestMapping(value = "getRequestParam", method = { RequestMethod.POST })
	public String getRequestParam(
			@ApiParam(value = "id", required = true) @RequestParam String id,
//			@RequestParam("password") String password,
//			@RequestHeader("name") String name,
			HttpServletRequest request) {
		System.out.println(request.getHeader("name") + "getRequestParam" + request.getParameter("password"));
		return "ddd";
	}

	@ApiOperation(value = "上传文件", notes = "上传文件", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "uploadFile", method = { RequestMethod.POST })
	public String uploadFile(@ApiParam(value = "id", required = true) @RequestParam MultipartFile file,
			HttpServletRequest request) {
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		return file.getName();
	}

	//
	// @ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "POST",
	// produces = MediaType.APPLICATION_JSON_VALUE)
	// @ResponseBody
	// @RequestMapping(value = "list_test", method = RequestMethod.POST)
	// public Result<User> list_test(
	// @ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
	// @ApiParam(value = "分类ID", required = true) @RequestParam Long
	// categoryId2,
	// @ApiParam(value = "token", required = true) @RequestParam String token) {
	// Result<User> result = new Result<User>();
	// User user = new User();
	// result.setData(user);
	// return result;
	// }
	//
	// private String findUser(User user) {
	// String token = user.getToken();
	// return token;
	// }
}