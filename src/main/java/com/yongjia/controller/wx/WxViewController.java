package com.yongjia.controller.wx;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yongjia.controller.web.WebBaseController;
import com.yongjia.dao.MemberCarMapper;
import com.yongjia.dao.MemberMapper;
import com.yongjia.dao.MemberPointMapper;
import com.yongjia.dao.MemberPointRecordMapper;
import com.yongjia.dao.MemberSignMapper;
import com.yongjia.dao.MemberSignRecordMapper;
import com.yongjia.dao.UserMapper;
import com.yongjia.dao.WxUserAndMemberMapper;
import com.yongjia.model.Member;
import com.yongjia.model.MemberCar;
import com.yongjia.model.User;
import com.yongjia.utils.CookieUtil;

@Controller
@RequestMapping("/wx/view")
public class WxViewController extends WebBaseController {

    private static Logger log = Logger.getLogger(WxViewController.class);

    @Autowired
    WxUserAndMemberMapper wxUserAndMemberMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MemberSignMapper memberSignMapper;

    @Autowired
    private MemberPointMapper memberPointMapper;

    @Autowired
    private MemberPointRecordMapper memberPointRecordMapper;

    @Autowired
    private MemberSignRecordMapper memberSignRecordMapper;

    @Autowired
    private MemberCarMapper memberCarMapper;

    @Autowired
    private MemberMapper memberMapper;

    @ModelAttribute
    public void populateModel(Model model) {
        model.addAttribute("shost", "http://yjstatic.tlan.com.cn");
    }

    /**
     * 我的首页
     * 
     * @param model
     * @param openid
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/mineHome")
    public String mineHome(Model model, HttpServletRequest request, HttpServletResponse response) {
        
        return "weixin/mineHome";
    }

    /**
     * 编辑用户信息
     * 
     * @param model
     * @return
     */
    @RequestMapping("/wxuserEdit")
    public String register(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "weixin/wxuserEdit";
    }

    /**
     * 查看用户信息
     * 
     * @param model
     * @param openid
     * @return
     */
    @RequestMapping("/wxuserInfo")
    public String wxuserInfo(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "/weixin/wxuserInfo";
    }


    /**
     * 用户添加车辆
     * 
     * @param model
     * @return
     */
    @RequestMapping("/addCar")
    public String addCar(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "weixin/addCar";
    }

    /**
     * 
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/myCars")
    public String myCars(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        List<MemberCar> memberCars = memberCarMapper.selectByMemberId(memberId, null);
        model.addAttribute("cars", memberCars);
        return "weixin/myCars";
    }


    /**
     * 销售登录
     * 
     * @param model
     * @return
     */
    @RequestMapping("/salerLogin")
    public String salerLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
        String openid = CookieUtil.getOpenid(request);
        User user = userMapper.selectByOpenid(openid);
        if (user == null) {
            return "weixin/salerLogin";
        } else {
            return "forward:/wx/view/mineHome";
        }
    }

    /**
     * 销售重置密码
     * 
     * @param model
     * @return
     */
    @RequestMapping("/salerResetPwd")
    public String salerResetPwd(Model model, HttpServletRequest request, HttpServletResponse response) {

        return "weixin/salerResetPwd";
    }


    /**
     * 道路救援
     * 
     * @param model
     * @return
     */
    @RequestMapping("/roadRescue")
    public String roadRescue(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "weixin/roadRescue";
    }

    /**
     * 预约维修
     * 
     * @param model
     * @return
     */
    @RequestMapping("/appointWeixiu")
    public String appointmentWeixiu(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        List<MemberCar> memberCars = memberCarMapper.selectByMemberId(memberId, MemberCar.StatusYes);

        model.addAttribute("wxuser", member);
        model.addAttribute("cars", memberCars);
        return "weixin/appointWeixiu";
    }

    @RequestMapping("/appointBaoyang")
    public String appointmentBaoyang(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        List<MemberCar> memberCars = memberCarMapper.selectByMemberId(memberId, MemberCar.StatusYes);

        model.addAttribute("wxuser", member);
        model.addAttribute("cars", memberCars);
        return "weixin/appointBaoyang";
    }

    @RequestMapping("/appointKanche")
    public String appointmentKanche(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        model.addAttribute("wxuser", member);
        return "weixin/appointKanche";
    }

    @RequestMapping("/appointNianshen")
    public String appointmentNianshen(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        List<MemberCar> memberCars = memberCarMapper.selectByMemberId(memberId, MemberCar.StatusYes);

        model.addAttribute("wxuser", member);
        model.addAttribute("cars", memberCars);
        return "weixin/appointNianshen";
    }

    @RequestMapping("/appointQita")
    public String appointmentQita(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        List<MemberCar> memberCars = memberCarMapper.selectByMemberId(memberId, MemberCar.StatusYes);

        model.addAttribute("wxuser", member);
        model.addAttribute("cars", memberCars);
        return "weixin/appointQita";
    }


    /**
     * 
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/buycarAdd")
    public String buycarAdd(Model model, HttpServletRequest request, HttpServletResponse response) {
        Long memberId = CookieUtil.getMemberId(request);
        Member member = memberMapper.selectByPrimaryKey(memberId);
        model.addAttribute("wxuser", member);

        return "weixin/buycarAdd";
    }

}