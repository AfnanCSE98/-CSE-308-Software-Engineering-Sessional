import java.util.*;
import java.io.*;

public class mediator_org implements mediator{
  private int no_of_org;
  private LinkedList<Pair>[] requests;
  private List<org> orgs;

  public mediator_org(int no_of_org){
    this.no_of_org = no_of_org;
    requests = new LinkedList[no_of_org];
    orgs = new ArrayList<org>();

    for(int i=0;i<no_of_org;i++){
      requests[i] = new LinkedList<Pair>();
    }
  }

  public void add_org(org ob){
    orgs.add(ob);
    ob.set_mediator(this);
  }

  @Override
  public void request(org ob , String service)
  {
    ///find idx of org who will serve the request of "service" asked by ob.
    int idx = get_index(service);
    Pair p = new Pair(ob.get_name() , service);
    requests[idx].add(p);
    //System.out.println(requests[idx]);
    System.out.println(ob.get_name() + " requests for " + service + " service");
  }

  @Override
  public void serve(org ob){
    int idx = get_index(ob.get_service());
    Pair p  = requests[idx].get(0);
    System.out.println(ob.get_name() + " serves the request of " + p.geta());
    requests[idx].removeFirst();
  }

  public int get_index(String service){
    int idx=0;
    for(int i=0;i<no_of_org;i++){
      if(service == orgs.get(i).get_service()){
        idx = i;break;
      }
    }
    return idx;
  }
}


class Pair{
  String a;String b;
  public Pair(String x , String y){a=x;b=y;}
  public String geta(){return a;}
  public String getb(){return b;}
}
