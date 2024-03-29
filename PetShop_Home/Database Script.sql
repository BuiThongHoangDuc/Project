USE [master]
GO
/****** Object:  Database [PetAssignment]    Script Date: 12/12/2019 4:35:14 PM ******/
CREATE DATABASE [PetAssignment]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PetAssignment', FILENAME = N'D:\DataBase\PetAssignment.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PetAssignment_log', FILENAME = N'D:\DataBase\PetAssignment_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [PetAssignment] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PetAssignment].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PetAssignment] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PetAssignment] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PetAssignment] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PetAssignment] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PetAssignment] SET ARITHABORT OFF 
GO
ALTER DATABASE [PetAssignment] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PetAssignment] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PetAssignment] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PetAssignment] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PetAssignment] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PetAssignment] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PetAssignment] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PetAssignment] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PetAssignment] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PetAssignment] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PetAssignment] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PetAssignment] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PetAssignment] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PetAssignment] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PetAssignment] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PetAssignment] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PetAssignment] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PetAssignment] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PetAssignment] SET  MULTI_USER 
GO
ALTER DATABASE [PetAssignment] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PetAssignment] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PetAssignment] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PetAssignment] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PetAssignment] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PetAssignment] SET QUERY_STORE = OFF
GO
USE [PetAssignment]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[BillID] [int] IDENTITY(1,1) NOT NULL,
	[BillDate] [datetime] NULL,
	[BillStatus] [int] NULL,
	[UserID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[BillID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillItems]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillItems](
	[BillItemsID] [int] IDENTITY(1,1) NOT NULL,
	[BillID] [int] NULL,
	[ProductID] [int] NULL,
	[Price] [float] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[BillItemsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EndUser]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EndUser](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](50) NULL,
	[UserFullName] [varchar](50) NULL,
	[UserPassword] [varchar](20) NULL,
	[UserEmail] [varchar](50) NULL,
	[UserAdress] [varchar](50) NULL,
	[UserPhoneNum] [varchar](15) NULL,
	[UserStatus] [int] NULL,
	[UserRole] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pet]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pet](
	[PetID] [int] IDENTITY(1,1) NOT NULL,
	[PetName] [varchar](50) NULL,
	[PetType] [varchar](10) NULL,
	[PetStatus] [int] NULL,
	[UserID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[PetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [varchar](50) NULL,
	[ProductDetail] [varchar](max) NULL,
	[ProductImage] [varchar](50) NULL,
	[ProductPrice] [float] NULL,
	[ProductQuantity] [int] NULL,
	[ProductStatus] [int] NULL,
	[ProductIsDelete] [int] NULL,
	[TypeID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ServicePet]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ServicePet](
	[ServiceID] [int] IDENTITY(1,1) NOT NULL,
	[ServiceName] [varchar](50) NULL,
	[SerivcePrice] [float] NULL,
	[ServiceImage] [varchar](100) NULL,
	[TypePetService] [varchar](10) NULL,
	[SerivceStatus] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ServiceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TypeOfProduct]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeOfProduct](
	[TypeID] [int] NOT NULL,
	[TypeName] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[TypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TypeRole]    Script Date: 12/12/2019 4:35:15 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeRole](
	[UserRole] [int] NOT NULL,
	[RoleName] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[UserRole] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([BillID], [BillDate], [BillStatus], [UserID]) VALUES (1, CAST(N'2019-12-12T13:11:39.000' AS DateTime), 1, 3)
SET IDENTITY_INSERT [dbo].[Bill] OFF
SET IDENTITY_INSERT [dbo].[BillItems] ON 

INSERT [dbo].[BillItems] ([BillItemsID], [BillID], [ProductID], [Price], [Quantity]) VALUES (1, 1, 4, 1000000, 2)
SET IDENTITY_INSERT [dbo].[BillItems] OFF
SET IDENTITY_INSERT [dbo].[EndUser] ON 

INSERT [dbo].[EndUser] ([UserID], [UserName], [UserFullName], [UserPassword], [UserEmail], [UserAdress], [UserPhoneNum], [UserStatus], [UserRole]) VALUES (1, N'HDuc', N'Bui Thong Hoang Duc', N'Huynhnhu12', N'alksjd@gmail.com', N'2549/28/3/3', N'093361185', 1, 1)
INSERT [dbo].[EndUser] ([UserID], [UserName], [UserFullName], [UserPassword], [UserEmail], [UserAdress], [UserPhoneNum], [UserStatus], [UserRole]) VALUES (2, N'DKhoa', N'Dinh Tran Anh Khoa', N'1', N'asd@gmail.com', N'2549/5/5', N'0123456789', 1, 2)
INSERT [dbo].[EndUser] ([UserID], [UserName], [UserFullName], [UserPassword], [UserEmail], [UserAdress], [UserPhoneNum], [UserStatus], [UserRole]) VALUES (3, N'NgocDuc', N'Tran Ngoc Duc', N'2', N'zxc@gmail.com', N'25558', N'012356987', 1, 2)
SET IDENTITY_INSERT [dbo].[EndUser] OFF
SET IDENTITY_INSERT [dbo].[Pet] ON 

INSERT [dbo].[Pet] ([PetID], [PetName], [PetType], [PetStatus], [UserID]) VALUES (1, N'Shit', N'1', 0, 3)
INSERT [dbo].[Pet] ([PetID], [PetName], [PetType], [PetStatus], [UserID]) VALUES (2, N'Help', N'1', 0, 3)
INSERT [dbo].[Pet] ([PetID], [PetName], [PetType], [PetStatus], [UserID]) VALUES (3, N'Out', N'1', 0, 3)
SET IDENTITY_INSERT [dbo].[Pet] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductID], [ProductName], [ProductDetail], [ProductImage], [ProductPrice], [ProductQuantity], [ProductStatus], [ProductIsDelete], [TypeID]) VALUES (4, N'vaults of atziri', N'asdoiashdkjlasjdlkasj', N'catproduct1.jpg', 500000, 48, 1, 0, 2)
INSERT [dbo].[Product] ([ProductID], [ProductName], [ProductDetail], [ProductImage], [ProductPrice], [ProductQuantity], [ProductStatus], [ProductIsDelete], [TypeID]) VALUES (5, N'vaults of atziri 2', N'laksjdflxoicvuiouiouoiasidpo', N'catproduct2.jpg', 500610, 10, 1, 0, 2)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[ServicePet] ON 

INSERT [dbo].[ServicePet] ([ServiceID], [ServiceName], [SerivcePrice], [ServiceImage], [TypePetService], [SerivceStatus]) VALUES (1, N'Take a bath', 200000, N'Service2.jpg', N'1', 0)
SET IDENTITY_INSERT [dbo].[ServicePet] OFF
INSERT [dbo].[TypeOfProduct] ([TypeID], [TypeName]) VALUES (2, N'Cat')
INSERT [dbo].[TypeOfProduct] ([TypeID], [TypeName]) VALUES (1, N'Dog')
INSERT [dbo].[TypeRole] ([UserRole], [RoleName]) VALUES (1, N'Admin')
INSERT [dbo].[TypeRole] ([UserRole], [RoleName]) VALUES (2, N'User')
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Pet__040AC0535AF3076F]    Script Date: 12/12/2019 4:35:15 PM ******/
ALTER TABLE [dbo].[Pet] ADD UNIQUE NONCLUSTERED 
(
	[PetName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Product__DD5A978AA296281C]    Script Date: 12/12/2019 4:35:15 PM ******/
ALTER TABLE [dbo].[Product] ADD UNIQUE NONCLUSTERED 
(
	[ProductName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ServiceP__A42B5F99D550A124]    Script Date: 12/12/2019 4:35:15 PM ******/
ALTER TABLE [dbo].[ServicePet] ADD UNIQUE NONCLUSTERED 
(
	[ServiceName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__TypeOfPr__D4E7DFA8985C77E5]    Script Date: 12/12/2019 4:35:15 PM ******/
ALTER TABLE [dbo].[TypeOfProduct] ADD UNIQUE NONCLUSTERED 
(
	[TypeName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[EndUser] ([UserID])
GO
ALTER TABLE [dbo].[BillItems]  WITH CHECK ADD FOREIGN KEY([BillID])
REFERENCES [dbo].[Bill] ([BillID])
GO
ALTER TABLE [dbo].[BillItems]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[EndUser]  WITH CHECK ADD FOREIGN KEY([UserRole])
REFERENCES [dbo].[TypeRole] ([UserRole])
GO
ALTER TABLE [dbo].[Pet]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[EndUser] ([UserID])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([TypeID])
REFERENCES [dbo].[TypeOfProduct] ([TypeID])
GO
USE [master]
GO
ALTER DATABASE [PetAssignment] SET  READ_WRITE 
GO
