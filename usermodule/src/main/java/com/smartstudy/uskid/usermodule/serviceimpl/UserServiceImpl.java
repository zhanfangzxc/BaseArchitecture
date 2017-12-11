package com.smartstudy.uskid.usermodule.serviceimpl;


import android.support.v4.app.Fragment;

import com.smartstudy.uskid.componentservice.UserService;
import com.smartstudy.uskid.usermodule.fragment.LoginFragment;

/**
 * @author 赵珊珊
 * @date 2017/12/7
 */

public class UserServiceImpl implements UserService {
    @Override
    public Fragment getUserService() {
        return new LoginFragment();
    }
}
