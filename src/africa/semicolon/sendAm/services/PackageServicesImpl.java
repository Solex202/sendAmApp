package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.models.Package;
import africa.semicolon.sendAm.data.models.PackageDescription;
import africa.semicolon.sendAm.data.models.Status;
import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.data.repositories.PackageRepositoryImpl;
import africa.semicolon.sendAm.dtos.request.AddPackageRequest;
import africa.semicolon.sendAm.dtos.request.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.response.AddPackageResponse;
import africa.semicolon.sendAm.exceptions.RegisterFailureException;

public class PackageServicesImpl implements PackageServices{
    private PackageRepository packageRepository = new PackageRepositoryImpl();
    @Override
    public AddPackageResponse addPackage(AddPackageRequest myPackage) {

        Package packageToBeAdded = new Package();
        packageToBeAdded.setName(myPackage.getName());
        packageToBeAdded.setWeightInGrammes(myPackage.getWeightInGrammes());
        Status status = new Status();
        status.setStatus("created");
        packageToBeAdded.getStatusList().add(status);
         Package savedPackage =  packageRepository.save(packageToBeAdded);

         AddPackageResponse packageResponse = new AddPackageResponse();
         packageResponse.setId(savedPackage.getId());
         packageResponse.setName(savedPackage.getName());
         packageResponse.setWeightInGrammes(savedPackage.getWeightInGrammes());
        return packageResponse;
    }

    private boolean packageExist(int id) {
        Package myPackage = packageRepository.findById(id);
        if(myPackage == null) return false;
        return true;
    }

    @Override
    public PackageRepository getRepository() {
        return packageRepository;
    }

    @Override
    public void updateTrackingInfo(UpdateTrackingInfoRequest trackingRequest) {
        Package foundPackage = packageRepository.findById(trackingRequest.getTrackingNumber());
        System.out.println(trackingRequest.getTrackingNumber());
        Status status = new Status();

        //create new status
        status.setStatus(trackingRequest.getTrackingInfo());
        foundPackage.getStatusList().add(status);
        packageRepository.save(foundPackage);
    }
}
