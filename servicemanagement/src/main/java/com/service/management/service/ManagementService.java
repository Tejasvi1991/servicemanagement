package com.service.management.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.model.ServiceData;
import com.service.repository.ServiceRepository;
/**
 * @author Tejasvi
 *
 */
@Service
public class ManagementService {

	@Autowired
	private ServiceRepository serviceRepository;
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

	/**getAllServiceDetails() -> To get all Service Details
	 * @return
	 */
	public List<ServiceData> getAllServiceDetails() {
		List<ServiceData> serviceDataDbList = (List<ServiceData>) serviceRepository.findAll();
		List<ServiceData> serviceDataList = new ArrayList<>();
		if (null != serviceDataDbList && serviceDataDbList.size() > 0) {
			serviceDataList.addAll(serviceDataDbList);
		}
		return serviceDataList;
	}

	/**addNewService() -> To save the Details after adding new Service
	 * @param serviceData
	 * @return
	 * @throws ParseException
	 */
	public ServiceData addNewService(ServiceData serviceData) throws ParseException {
    	//serviceData.setStatus(checkURL(serviceData.getUrl()));
		serviceData.setCreateDate(df.parse(df.format(new Date())));
		serviceData.setUpdateDate(df.parse(df.format(new Date())));
		ServiceData savedService = serviceRepository.save(serviceData);
		return savedService;
	}

	/**updateServiceDetails() -> To Update Service Details from Update Service
	 * @param id
	 * @param inputdatata
	 * @return
	 * @throws ParseException
	 */
	public ServiceData updateServiceDetails(int id, ServiceData inputdatata) throws ParseException {
		Optional<ServiceData> serviceDataDB = serviceRepository.findById(id);
		ServiceData serviceData = new ServiceData();
		if (serviceDataDB.isPresent()) {
			serviceData = serviceDataDB.get();
			if (null != inputdatata.getServiceName()) {
				serviceData.setServiceName(inputdatata.getServiceName());
			}
			if (null != inputdatata.getUrl()) {
				serviceData.setUrl(inputdatata.getUrl());
				serviceData.setStatus(checkURL(serviceData.getUrl()));
			}
			serviceData.setUpdateDate(df.parse(df.format(new Date())));
			serviceRepository.save(serviceData);
		}
		return serviceData;
	}

	/**deleteServiceDetails() -> To Delete a service Service for a particular id
	 * @param id
	 * @return
	 */
	public ServiceData deleteServiceDetails(int id) {
		Optional<ServiceData> serviceDataDB = serviceRepository.findById(id);
		ServiceData serviceData = new ServiceData();
		if (serviceDataDB.isPresent()) {
			serviceData = serviceDataDB.get();
			serviceRepository.delete(serviceData);
		}
		return serviceData;
	}

	/**findServiceById() -> To find service details based o a particular Service Id
	 * @param id
	 * @return
	 */
	public ServiceData findServiceById(int id) {
		Optional<ServiceData> serviceDataDB = serviceRepository.findById(id);
		ServiceData serviceData = new ServiceData();
		if (serviceDataDB.isPresent()) {
			serviceData = serviceDataDB.get();
		}
		return serviceData;
	}

	/**checkURL() -> To Check a service ip up or not
	 * @param url
	 * @return
	 */
	public int checkURL(String url) {

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				return 404;
			}
		} catch (IOException exception) {
			return 404;
		}
		return 200;
	}

}
