package com.amljdhv.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "aboutUs";
    }
    
    @GetMapping("/contactUs")
    public String contactUs() {
        return "/contactUs";
    }
    
    /** secure pages call*/
    
    @GetMapping("/changePassword")
    public String changePassword() {
        return "/changePassword/change-password";
    }

    /** Reward point actions*/
    
    @GetMapping("/addRewardPoint")
    public String addRewardPoint() {
        return "/rewardPoint/addRewardPoint";
    }
    
    @GetMapping("/userRewardPointDetails")
    public String userRewardPointDetails() {
        return "/rewardPoint/userRewardPointDetails";
    }
    
    //earningRule.html
    
    @GetMapping("/addEarningRule")
    public String addEarningRule() {
        return "/rewardPoint/EarningRule";
    }
    
    ///addManualRewardTransaction
    @GetMapping("/addManualRewardTransaction")
    public String addManualRewardTransaction() {
        return "/rewardPoint/addManualRewardTransaction";
    }    
    
    // product pages
    
    @GetMapping("/addProduct")
    public String addProduct() {
        return "/product/addProduct";
    }
    
    @GetMapping("product.add")
	public String addProduct(Model model){
		return "product/product";
	}
    
    /** error pages*/
    
    @GetMapping("/access-denied")
    public String error403() {
        return "/error/403";
    }
    
    //user.subscription
    @GetMapping("/user.subscription")
    public String userSubscription() {
        return "/user/consumer-subscription";
    }
    
    ///home
    
    @GetMapping("/home")
    public String home() {
        return "home/homeSignedIn";
    }
    
    @GetMapping("/users")
    public String users() {
        return "user/users-list";
    }
    
    
    @GetMapping("/add.reward")
    public String addReward() {
        return "rewardPoint/add-reward-form.html";
    }
    
    @GetMapping("/add.social.media.rule")
    public String addSocialMediaEarningRule() {
        return "rewardPoint/social-media-reward.html";
    }
    
    @GetMapping("/user.points.details")
    public String userPointsDetails() {
        return "rewardPoint/userRewardPointDetails.html";
    }
    
    //
    @GetMapping("/view.earning.rule")
    public String viewEarningRule() {
        return "rewardPoint/viewEarningRule.html";
    }
}
