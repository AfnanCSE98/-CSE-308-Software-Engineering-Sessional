import java.util.*;
import java.io.*;

public class jpdc implements org{
  private final String org_name = "JPDC";
  private String org_service;
  private mediator_org m_org;

  public jpdc(String org_service)
  {
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
