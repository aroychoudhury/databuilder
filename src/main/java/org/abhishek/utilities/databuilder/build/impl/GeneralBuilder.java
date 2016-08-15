package org.abhishek.utilities.databuilder.build.impl;

import java.util.Random;

import org.abhishek.utilities.databuilder.build.AbstractBuilder;
import org.abhishek.utilities.databuilder.build.ctx.BuildContext;
import org.abhishek.utilities.databuilder.data.GeneralData;

public class GeneralBuilder extends AbstractBuilder {
    private Random random = new Random();

    public String getLanguage() {
        return GeneralData.LANGUAGES[random.nextInt(GeneralData.LANGUAGES.length)];
    }

    public String getIPv4() {
        return GeneralData.IP_ADDRESS_V4[random.nextInt(GeneralData.IP_ADDRESS_V4.length)];
    }

    public String getIPv6() {
        return GeneralData.IP_ADDRESS_V6[random.nextInt(GeneralData.IP_ADDRESS_V6.length)];
    }

    public String getSize() {
        return GeneralData.SIZES[random.nextInt(GeneralData.SIZES.length)];
    }

    public String getJobTitle() {
        return GeneralData.JOB_TITLES[random.nextInt(GeneralData.JOB_TITLES.length)];
    }

    public String getFileName() {
        return GeneralData.FILE_NAMES[random.nextInt(GeneralData.FILE_NAMES.length)];
    }

    public String getURL() {
        return GeneralData.URLS[random.nextInt(GeneralData.URLS.length)];
    }

    public String getMimeType() {
        return GeneralData.MIME_TYPES[random.nextInt(GeneralData.MIME_TYPES.length)];
    }

    public String getCompanyNames() {
        return GeneralData.COMPANY_NAMES[random.nextInt(GeneralData.COMPANY_NAMES.length)];
    }

    @Override
    public void constructContext(BuildContext context) {
        context.put("url", this.getURL());
        context.put("fileName", this.getFileName());
        context.put("mime", this.getMimeType());
        context.put("job", this.getJobTitle());
        context.put("ipv6", this.getIPv6());
        context.put("ipv4", this.getIPv4());
        context.put("language", this.getLanguage());
        context.put("size", this.getSize());
    }

    public static void main(String[] args) {
        GeneralBuilder parser = new GeneralBuilder();
        System.out.println(parser.getURL());
        System.out.println(parser.getFileName());
        System.out.println(parser.getMimeType());
        System.out.println(parser.getJobTitle());
        System.out.println(parser.getIPv6());
        System.out.println(parser.getLanguage());
    }
}
