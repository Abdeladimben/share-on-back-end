package com.example.share.helpers;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

public class Utils {

	private static final String DELIMITER = "/";

	private Utils() {
		throw new IllegalStateException("Utils class");
	}

	public static String formatDate(LocalDate date) {

		LocalDateTime localDateTime = date.atStartOfDay();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return localDateTime.format(formatter);
	}

	public static String formatDate(LocalDateTime date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
		return date.format(formatter);
	}

	public static File multipartToFile(MultipartFile multipart, String filename)
			throws IllegalStateException, IOException {
		File convFile = new File(System.getProperty("java.io.tmpdir") + DELIMITER + filename);
		multipart.transferTo(convFile);
		return convFile;
	}

	public static Pageable getPagingsort(int page, int size, String[] sort) {
		List<Sort.Order> orders = new ArrayList<>();
		if (sort[0].contains(",")) {
			for (String sortOrder : sort) {
				String[] sortSplited = sortOrder.split(",");
				orders.add(new Sort.Order(getSortDirection(sortSplited[1]), sortSplited[0]));
			}
		} else {
			orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
		}
		return PageRequest.of(page, size, Sort.by(orders));
	}

	private static Sort.Direction getSortDirection(String direction) {
		if (direction.equals("asc")) {
			return Sort.Direction.ASC;
		} else if (direction.equals("desc")) {
			return Sort.Direction.DESC;
		}

		return Sort.Direction.ASC;
	}

	public static boolean empty(final String s) {
		// Null-safe, short-circuit evaluation.
		return s == null || s.trim().isEmpty();
	}

	public static <R> Predicate<R> not(Predicate<R> predicate) {
		return predicate.negate();
	}
}
