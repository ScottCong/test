package test;

public enum EOrderTyper {  
    /** 
   * 无效的订单类型 
   */  
  Invalid(-1,"无效的订单类型"),  
    
  /** 
   * 一般订单 
   */  
  NormalOrder(0, "一般订单"),  
    
  /** 
   * 虚拟礼品卡订单 
   */  
  VDDmoney(50, "虚拟订单"),  
    
  /** 
   * 实物礼品卡订单 
   */  
  PDDmoney(51, "礼品卡订单");  
  private int orderType;  
  private String description;  
  private EOrderTyper(int type, String desc) {  
      this.orderType = type;  
      this.description = desc;  
  }  


  public int getOrderType() {  
      return this.orderType;  
  }  


  public String getDescription() {  
      return this.description;  
  }  
    
}  