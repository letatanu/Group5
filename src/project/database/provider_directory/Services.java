package project.database.provider_directory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Austin on 11/28/16.
 */
@XmlRootElement(name="services")
@XmlAccessorType(XmlAccessType.FIELD)
public class Services {

    @XmlElement(name="service")
    private ArrayList<Service> serviceList = null;

    // Constructors
    public Services() {
        serviceList = new ArrayList<Service>();
    }

    public Services(ArrayList<Service> services){
        if(serviceList == null){
            serviceList = new ArrayList<Service>();
            if(!services.isEmpty()){
                int servicesSize = services.size();
                for(int i=0; i < servicesSize; ++i){
                    serviceList.add(services.get(i));
                }
            }
        }
    }

    public void displayServices(){
        if (serviceList != null){
            if(!serviceList.isEmpty()){
                for(int i = 0; i < serviceList.size(); ++i){
                    Service current = serviceList.get(i);
                    current.display();
                }
            }
            else
                System.out.println("There are no services to display.");
        }
    }

    public boolean addService(Service toAdd){
        if(toAdd != null){
            if(serviceList == null){
                System.out.println("Service list is null. Initializing...");
                serviceList = new ArrayList<Service>();
                serviceList.add(toAdd);
            }
            else
                serviceList.add(toAdd);
            return true;
        }
        return false;
    }

    /**
     * Returns a corresponding service that matches
     * the service code passed in.
     *
     * @param serviceCode // service id to be searched for
     * @return
     */
    public Service getService(String serviceCode){
        if(!serviceList.isEmpty() && serviceCode != null){
            for(int i=0; i <serviceList.size(); ++i){
                if((serviceList.get(i)).getServiceCode().equals(serviceCode)){
                    System.out.println("Found match in database.");
                    return serviceList.get(i);
                }
            }
        }
        return null; // Didn't find match or bad @param.
    }

    public boolean isService(String serviceCode){
        if(!serviceList.isEmpty() && serviceCode != null){
            if(getService(serviceCode) != null){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of services
     * that are present in ArrayList
     * "services".
     *
     * @return services.size()
     */
    public int countServices(){
        try{
            return serviceList.size();
        }catch(Exception e){ // Edge cases: maxInt = 2,147,483,648.
            e.printStackTrace();
            return 0;
        }
    }
}
