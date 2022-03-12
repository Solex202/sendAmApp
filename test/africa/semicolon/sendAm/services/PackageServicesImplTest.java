package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.dtos.request.AddPackageRequest;
import africa.semicolon.sendAm.dtos.request.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.response.AddPackageResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PackageServicesImplTest {

    private PackageServices packageServices;

    @BeforeEach
    public void setUp(){
        packageServices = new PackageServicesImpl();
    }


    @Test
    void packageCanBeAddedToTheRepository(){
        //given
        AddPackageRequest packageAdd = new AddPackageRequest();
        packageAdd.setWeightInGrammes(50);
        packageAdd.setName("food");
        //when
        packageServices.addPackage(packageAdd);
        //assert
        assertEquals(1, packageServices.getRepository().count());
        assertEquals("food",packageAdd.getName());
    }


    @Test
        public void additionReturnsCorrectResponseTest(){
         //given
         AddPackageRequest packageAdd = new AddPackageRequest();
        packageAdd.setWeightInGrammes(50);
        packageAdd.setName("food");
        //when
//        packageServices.addPackage(packageAdd);
         AddPackageResponse packageResponse = packageServices.addPackage(packageAdd);
         //assert
         assertEquals(1,packageResponse.getId());
         assertEquals("food",packageResponse.getName());
         assertEquals(50, packageResponse.getWeightInGrammes());
    }

    @Test
    void addingAnotherPackageGivesCorrectResponse(){
        //given
        AddPackageRequest packageAdd = new AddPackageRequest();
        packageAdd.setWeightInGrammes(50);
        packageAdd.setName("food");
    packageServices.addPackage(packageAdd);

    AddPackageRequest newPackage = new AddPackageRequest();
        newPackage.setWeightInGrammes(70);
        newPackage.setName("ice");
        //when

        AddPackageResponse packageResponse = packageServices.addPackage(newPackage);

        assertEquals(2,packageResponse.getId());
        assertEquals(70,packageResponse.getWeightInGrammes());
        assertEquals("ice",packageResponse.getName());
    }

    @Test
    void testThatStatusIsUpdatedWhenNewPackageIsCreated(){
        //given
        AddPackageRequest packageAdd = new AddPackageRequest();
        packageAdd.setWeightInGrammes(50);
        packageAdd.setName("food");
        packageServices.addPackage(packageAdd);

       Package savedPackage = packageServices.getRepository().findById(1);
        assertEquals(1,savedPackage.getStatusList().size());
    }

    @Test
    void testThatWeCanUpdateStatus(){
        //given
        AddPackageRequest packageAdd = new AddPackageRequest();
        packageAdd.setWeightInGrammes(50);
        packageAdd.setName("food");
        packageServices.addPackage(packageAdd);
        System.out.println(packageAdd);
        UpdateTrackingInfoRequest updateTrackingRequest = new UpdateTrackingInfoRequest();
        updateTrackingRequest.setTrackingInfo("arrived at sabo");
        updateTrackingRequest.setTrackingNumber(1);

        packageServices.updateTrackingInfo(updateTrackingRequest);

        Package savedPackage = packageServices.getRepository().findById(1);
        System.out.println(savedPackage);

        assertEquals(2,savedPackage.getStatusList().size());
    }

}