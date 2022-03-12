package africa.semicolon.sendAm.controllers;

import africa.semicolon.sendAm.dtos.request.AddPackageRequest;
import africa.semicolon.sendAm.dtos.response.AddPackageResponse;
import africa.semicolon.sendAm.services.PackageServices;
import africa.semicolon.sendAm.services.PackageServicesImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/package")

public class PackageController {

    private PackageServices packageServices = new PackageServicesImpl();

    @PostMapping("/addPackage")
    public AddPackageResponse addNewPackage(@RequestBody AddPackageRequest packageToAdd){
        return packageServices.addPackage(packageToAdd);
    }
}
