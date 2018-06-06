package com.nike.oregon.spring.resource;

        import com.nike.oregon.spring.entity.Cruise;
        import com.nike.oregon.spring.service.AwsService;
        import com.nike.oregon.spring.service.CruiseService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;

        import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by VRadh1 on 3/30/2017.
 */
@RestController
@RequestMapping(value = "/v1/nike", produces = {APPLICATION_JSON_VALUE})
public class CruiseResource {
    private static final Logger logger = LoggerFactory.getLogger(CruiseResource.class);

    @Autowired
    CruiseService cruiseService;

    @Autowired
    AwsService awsService;

    @RequestMapping(value = "/cruises/{country}", method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cruise>> getCountries(@PathVariable(value = "country") String country) {

        logger.info("getCountries..............invokeddddd");
        awsService.configure();
        List<Cruise> cruises = cruiseService.getCruises(country);
        return new ResponseEntity(cruises, HttpStatus.OK);
    }
}
