package africa.semicolon.sendAm.services;

import africa.semicolon.sendAm.data.repositories.PackageRepository;
import africa.semicolon.sendAm.dtos.request.AddPackageRequest;
import africa.semicolon.sendAm.dtos.request.UpdateTrackingInfoRequest;
import africa.semicolon.sendAm.dtos.response.AddPackageResponse;

public interface PackageServices {
 AddPackageResponse addPackage (AddPackageRequest myPackage);

    PackageRepository getRepository();

    void updateTrackingInfo(UpdateTrackingInfoRequest trackingRequest);
}
