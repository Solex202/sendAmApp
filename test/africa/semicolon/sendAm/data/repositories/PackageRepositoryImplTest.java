package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class PackageRepositoryImplTest {
    private PackageRepository packageRepository;
    @BeforeEach
    void setup() {
        packageRepository  = new PackageRepositoryImpl();
    }

    @Test
    void repositorySaveTest()  {
        //given there is a package
        Package aPackage = new Package();
        //when i try to save in the repo
        Package savedPackage = packageRepository.save(aPackage);
        //assert that the returned ,has an id
        assertEquals(1,savedPackage.getId());
        assertEquals(1,packageRepository.count());
        //assert that the count is 1
    }

    @Test
    void repositoryFindById(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        Package foundPackage = packageRepository.findById(2);

        assertEquals(secondPackage,foundPackage);
        assertEquals(2,foundPackage.getId());
    }

    @Test
    void deleteByIdTest(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        packageRepository.delete(2);
        assertEquals(2,packageRepository.count());
    }

    private void saveThreePackage(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();

        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

    }

    @Test
    void findByIdWorks_afterDeleteTest(){
       saveThreePackage();

       packageRepository.delete(2);

       Package foundPackage = packageRepository.findById(2);
       assertNull(foundPackage);
    }

    @Test
    void saveAfterDelete_givesCorrectPackageIdTest(){
        saveThreePackage();
        packageRepository.delete(1);
        Package savedPackage = packageRepository.save(new Package());
        assertEquals(4, savedPackage.getId());
    }

    @Test
    void deleteByPackage(){
        Package firstPackage = new Package();
        Package secondPackage = new Package();
        Package thirdPackage = new Package();
        packageRepository.save(firstPackage);
        packageRepository.save(secondPackage);
        packageRepository.save(thirdPackage);

        packageRepository.delete(secondPackage);

        assertEquals(2,packageRepository.count());
    }

    @Test
    void findAllTest(){
        saveThreePackage();
        List<Package> all = packageRepository.findAll();
        assertEquals(3,all.size());
    }
}