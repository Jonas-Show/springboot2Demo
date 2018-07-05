//package com.udian.controller;
//
//
//import com.baomidou.mybatisplus.plugins.Page;
//import com.udian.entity.TblBaseBus;
//import com.udian.service.TblBaseBusService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * <p>
// * 公交车辆基础信息表 前端控制器
// * </p>
// *
// * @author Junkie
// * @since 2018-05-15
// */
//@RestController
//@RequestMapping("/tblBaseBus")
//public class TblBaseBusController {
//    @Autowired
//    TblBaseBusService tblBaseBusService;
//
//    @RequestMapping("/queryAll")
//    public List<TblBaseBus> queryAllBus(){
////        EntityWrapper<TblBaseBus> wrapper = new EntityWrapper<>();
////        return tblBaseBusService.selectList(wrapper);
//        Page<TblBaseBus> tblBaseBusPage = tblBaseBusService.selectPage(new Page<>(1, 10));
//        return tblBaseBusPage.getRecords();
//    }
//}
//
