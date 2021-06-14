import java.util.*;
import java.io.*;

public class public_service_org implements org{
  private String org_name;
  private String org_service;
  private mediator_org m_org;

  public public_service_org(String org_name , String org_service)
  {
    this.org_name = org_name;
    this.org_service = org_service;
  }

  public void set_mediator(mediator_org mo){
    m_org = mo;
  }

  @Override
  public void request(String service){
    m_org.request(this , service);
  }

  @Override
  public void serve(){
    m_org.serve(this);
  }

  public String get_name(){
    return org_name;
  }

  public String get_service(){
    return org_service;
  }

}
