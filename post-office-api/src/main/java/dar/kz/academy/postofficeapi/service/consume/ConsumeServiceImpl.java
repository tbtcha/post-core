package dar.kz.academy.postofficeapi.service.consume;

import dar.kz.academy.postofficeapi.feign.ClientCoreModel;
import dar.kz.academy.postofficeapi.feign.ClientFeign;
import dar.kz.academy.postofficeapi.feign.MunicipalOfficeModel;
import dar.kz.academy.postofficeapi.service.MunicipalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService{
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    ClientFeign clientFeign;
    @Autowired
    MunicipalService municipalService;
    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeMessage(MunicipalOfficeModel officeModel) {
        log.info("Message: {} successfully consumed", officeModel);
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };

        ClientCoreModel client = clientFeign.getClientById(officeModel.getClientId());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@dar.tech");
        message.setTo(client.getEmail());
        message.setSubject(officeModel.getStatus());
        message.setText(municipalService.getClientMunicipalList(officeModel.getClientId(), pageable).toString());
        emailSender.send(message);
    }
}
