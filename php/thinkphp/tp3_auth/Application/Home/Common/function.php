<?php

/*
* 过滤所有用户组，显示当前用户是否在这些组中
*/
function getUserGroup($userInfo,$allGroupAccess){

    foreach ($userInfo as $v){
        //如果当前角色在此用户组则返回1，不在返回0
        $v['groupOk']=$allGroupAccess[$v]['uid']==$userInfo['id']?1:0;
    }

    return $group;
}


?>