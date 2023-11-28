package generator.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

/**
* 文章表
* @TableName sg_article
*/
@Data
public class SgArticleAddDTO implements Serializable {

    /**
    * 文章唯一ID
    */
    @NotNull(message="[文章唯一ID]不能为空")
    @ApiModelProperty("文章唯一ID")
    private Long id;
    /**
    * 标题
    */
    @Size(max= 256,message="标题长度不能超过256")
    @ApiModelProperty("标题")
    private String title;
    /**
    * 文章内容
    */
    @Size(max= -1,message="文章内容长度不能超过-1")
    @ApiModelProperty("文章内容")
    private String content;
    /**
    * 文章摘要
    */
    @Size(max= 1024,message="文章摘要长度不能超过1024")
    @ApiModelProperty("文章摘要")
    private String summary;
    /**
    * 所属分类id
    */
    @ApiModelProperty("所属分类id")
    private Long categoryId;
    /**
    * 缩略图
    */
    @Size(max= 256,message="缩略图长度不能超过256")
    @ApiModelProperty("缩略图")
    private String thumbnail;
    /**
    * 是否置顶（0否，1是）
    */
    @ApiModelProperty("是否置顶（0否，1是）")
    private String isTop;
    /**
    * 状态（0已发布，1草稿）
    */
    @ApiModelProperty("状态（0已发布，1草稿）")
    private String status;
    /**
    * 访问量
    */
    @ApiModelProperty("访问量")
    private Long viewCount;
    /**
    * 是否允许评论 1是，0否
    */
    @ApiModelProperty("是否允许评论 1是，0否")
    private String isComment;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long createBy;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date createTime;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long updateBy;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date updateTime;
    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;
}
