/*
 * Copyright 2013-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.openfeign.encoding;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The Feign encoding properties.
 *
 * @author Jakub Narloch
 * @author André Teigler
 */
@ConfigurationProperties("spring.cloud.openfeign.compression.request")
public class FeignClientEncodingProperties {

	/**
	 * The list of supported mime types.
	 */
	private String[] mimeTypes = new String[] { "text/xml", "application/xml", "application/json" };

	/**
	 * The minimum threshold content size.
	 */
	private int minRequestSize = 2048;

	/**
	 * The list of content encodings (applicable encodings depend on the used client).
	 */
	private String[] contentEncodingTypes = new String[] { HttpEncoding.GZIP_ENCODING, HttpEncoding.DEFLATE_ENCODING };

	public String[] getMimeTypes() {
		return mimeTypes;
	}

	public void setMimeTypes(String[] mimeTypes) {
		this.mimeTypes = mimeTypes;
	}

	public int getMinRequestSize() {
		return minRequestSize;
	}

	public void setMinRequestSize(int minRequestSize) {
		this.minRequestSize = minRequestSize;
	}

	public String[] getContentEncodingTypes() {
		return contentEncodingTypes;
	}

	public void setContentEncodingTypes(String[] contentEncodingTypes) {
		this.contentEncodingTypes = contentEncodingTypes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeignClientEncodingProperties that = (FeignClientEncodingProperties) o;
		return Arrays.equals(mimeTypes, that.mimeTypes) && Objects.equals(minRequestSize, that.minRequestSize)
				&& Arrays.equals(contentEncodingTypes, that.contentEncodingTypes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Arrays.hashCode(mimeTypes), minRequestSize);
	}

	@Override
	public String toString() {
		return new StringBuilder("FeignClientEncodingProperties{").append("mimeTypes=")
			.append(Arrays.toString(mimeTypes))
			.append(", ")
			.append("minRequestSize=")
			.append(minRequestSize)
			.append(", ")
			.append("contentEncodingTypes=")
			.append(Arrays.toString(contentEncodingTypes))
			.append("}")
			.toString();
	}

}
