package com.kingapps.shopifymobiledeveloperchallenge;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    public Product(Integer id, String title, String bodyHtml, String vendor, String productType,
                   String createdAt, String handle, String updatedAt, String publishedAt,
                   Object templateSuffix, String tags, String publishedScope,
                   String adminGraphqlApiId, List<Variant> variants, List<Option> options,
                   List<Image> images, Image_ image) {
        this.id = id;
        this.title = title;
        this.bodyHtml = bodyHtml;
        this.vendor = vendor;
        this.productType = productType;
        this.createdAt = createdAt;
        this.handle = handle;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.templateSuffix = templateSuffix;
        this.tags = tags;
        this.publishedScope = publishedScope;
        this.adminGraphqlApiId = adminGraphqlApiId;
        this.variants = variants;
        this.options = options;
        this.images = images;
        this.image = image;
    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("body_html")
    @Expose
    private String bodyHtml;
    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("handle")
    @Expose
    private String handle;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("published_at")
    @Expose
    private String publishedAt;
    @SerializedName("template_suffix")
    @Expose
    private Object templateSuffix;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("published_scope")
    @Expose
    private String publishedScope;
    @SerializedName("admin_graphql_api_id")
    @Expose
    private String adminGraphqlApiId;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;
    @SerializedName("options")
    @Expose
    private List<Option> options = null;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;
    @SerializedName("image")
    @Expose
    private Image_ image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Object getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(Object templateSuffix) {
        this.templateSuffix = templateSuffix;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPublishedScope() {
        return publishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        this.publishedScope = publishedScope;
    }

    public String getAdminGraphqlApiId() {
        return adminGraphqlApiId;
    }

    public void setAdminGraphqlApiId(String adminGraphqlApiId) {
        this.adminGraphqlApiId = adminGraphqlApiId;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Image_ getImage() {
        return image;
    }

    public void setImage(Image_ image) {
        this.image = image;
    }

}