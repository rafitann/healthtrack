<%@page import="br.com.healthtrackfiap.controller.bean.WeightHeightBean"%>
<%@page import="br.com.healthtrackfiap.utils.FormatadorNumero"%>
<%@page import="br.com.healthtrackfiap.utils.FormatadorData"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.healthtrackfiap.models.WeightHeight"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>BMI · Health Track</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous" />
<link rel="stylesheet" href="./css/style.css" />
<link rel="stylesheet" href="./assets/fonts/style.css" />
</head>
<body>
	<nav class="navbar sticky-top flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Health
			track</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-toggle="collapse" data-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search" />
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link"
				href="../signin/index.html">Sign out</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="sidebar-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link" href="pressure">
								<svg height="20" viewBox="0 0 45 45" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
                    <path
										d="M43.0225 20.9773H32.8226C31.8743 17.6549 29.9797 14.0383 27.5722 10.975C26.675 9.83338 23.5741 6.1084 21.3442 6.1084C20.6175 6.1084 18.9918 6.56191 16.2685 9.59906C16.0254 9.87012 16.0481 10.2869 16.3192 10.5299C16.5903 10.7731 17.0071 10.7502 17.25 10.4792C19.1406 8.37062 20.6686 7.42676 21.3442 7.42676C21.5122 7.42676 22.16 7.50744 23.4419 8.54561C24.4215 9.33891 25.4912 10.4607 26.5357 11.7896C28.955 14.8679 30.8307 18.5178 31.6819 21.8032C31.9078 22.6755 32.0645 23.5282 32.1478 24.3375C32.1973 24.8207 32.2225 25.2945 32.2225 25.746C32.2225 29.6803 31.1526 32.7183 29.0423 34.7756C27.165 36.6058 24.503 37.5732 21.3442 37.5732C15.485 37.5732 11.6185 34.3249 10.6901 28.65L15.1278 24.2122L19.4118 28.4963C19.6692 28.7537 20.0865 28.7538 20.344 28.4963C20.6015 28.2388 20.6015 27.8214 20.344 27.5641L15.5939 22.8139C15.4702 22.6903 15.3026 22.6209 15.1277 22.6209C14.9528 22.6209 14.7853 22.6903 14.6616 22.8139L9.56373 27.9118C9.55855 27.917 9.55345 27.9219 9.54817 27.9265C9.54536 27.9289 9.54264 27.9315 9.53974 27.9339C9.41818 28.0449 9.26077 28.1061 9.09659 28.1061H1.97745C1.61394 28.1061 1.31827 27.8104 1.31827 27.4469C1.31827 27.0834 1.61394 26.7877 1.97745 26.7877H8.55079C8.72569 26.7877 8.89339 26.7182 9.01705 26.5945L14.6613 20.9494C14.9185 20.6923 15.337 20.6923 15.5941 20.9494L24.8349 30.1903C25.0924 30.4477 25.5097 30.4477 25.7672 30.1903L28.7343 27.2232C28.8589 27.0985 29.0246 27.0299 29.2008 27.0299C29.3769 27.0299 29.5426 27.0985 29.6672 27.2232C29.9239 27.4798 29.9238 27.8981 29.6672 28.1551L25.7658 32.0556C25.6424 32.1793 25.4774 32.2475 25.3011 32.2475C25.1246 32.2475 24.9589 32.179 24.8346 32.0548L22.3316 29.5517C22.0742 29.2943 21.6569 29.2942 21.3993 29.5517C21.1419 29.8092 21.1419 30.2266 21.3993 30.4839L23.9024 32.9869C24.2757 33.3603 24.7724 33.5658 25.3011 33.5658C25.8304 33.5658 26.327 33.3599 26.6987 32.9869L30.5997 29.0868C31.3699 28.3154 31.3697 27.0611 30.5994 26.2907C30.2258 25.9172 29.7291 25.7113 29.2008 25.7113C28.6725 25.7113 28.1758 25.9171 27.8021 26.2907L25.3011 28.7918L16.5264 20.0172C16.1528 19.6436 15.656 19.4378 15.1277 19.4378C14.5994 19.4378 14.1027 19.6436 13.729 20.0172L10.7349 23.0118C11.3608 19.6939 13.0519 16.0001 15.5272 12.6134C15.742 12.3195 15.6779 11.9071 15.384 11.6923C15.0902 11.4775 14.6778 11.5415 14.4629 11.8354C11.4304 15.9846 9.51891 20.6058 9.19731 24.5495L8.27771 25.4692H1.97754C0.887168 25.4692 0 26.3563 0 27.4467C0 28.5372 0.887168 29.4243 1.97754 29.4243H9.09668C9.22676 29.4243 9.35517 29.4108 9.48076 29.3859C10.0685 32.3867 11.4164 34.7433 13.4957 36.3982C15.545 38.0293 18.2589 38.8914 21.3442 38.8914C24.8539 38.8914 27.8341 37.7946 29.9627 35.7194C32.3371 33.4046 33.5409 30.049 33.5409 25.7458C33.5409 25.4805 33.5325 25.2084 33.5169 24.9322H38.6642C39.0284 24.9322 39.3234 24.6371 39.3234 24.273C39.3234 23.909 39.0284 23.6138 38.6642 23.6138H33.3872C33.327 23.1822 33.2484 22.7418 33.1525 22.2955H43.0225C43.386 22.2955 43.6816 22.5911 43.6816 22.9547C43.6816 23.3182 43.386 23.6138 43.0225 23.6138H41.5093C41.1452 23.6138 40.8502 23.909 40.8502 24.273C40.8502 24.6371 41.1452 24.9322 41.5093 24.9322H43.0225C44.1128 24.9322 45 24.0451 45 22.9547C45 21.8642 44.1128 20.9773 43.0225 20.9773Z"
										fill="inherit" stroke="none" />
                  </svg> Blood Pressure
						</a></li>
						<li class="nav-item"><a class="nav-link" href="exercise">
								<svg height="20px" viewBox="0 0 45 45" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
                    <path
										d="M7.3075 2.0047C8.00342 0.768164 9.33074 0 10.7716 0H22.4147C24.5955 0 26.3697 1.77425 26.3697 3.95508V9.22852C26.3697 11.4093 24.5955 13.1836 22.4147 13.1836H14.5045C13.7776 13.1836 13.1861 13.775 13.1861 14.502V24.8584C16.9875 23.8192 20.9946 23.6907 24.8466 24.4743C27.7815 21.6659 31.9383 20.5234 36.0893 21.5613C40.2397 22.5991 43.6842 25.9859 44.6701 30.2015C45.5179 33.8277 44.6913 37.5628 42.4021 40.4489C40.1083 43.3412 36.6993 45 33.0494 45C15.8391 45 3.92573 38.4604 0.731346 36.8628C0.284683 36.6395 0.00255585 36.183 0.00255585 35.6836V29.9644C0.00255585 20.1635 2.52862 10.4952 7.3075 2.0047ZM2.63927 34.8712C6.92227 37.0286 17.7647 42.3633 33.0494 42.3633C35.8895 42.3633 38.5455 41.0683 40.3364 38.8103C42.1224 36.5585 42.7662 33.6395 42.1026 30.8017C41.3571 27.6132 38.6835 24.9277 35.4498 24.1191C32.7948 23.4552 30.133 23.9092 27.9837 25.3279C29.0116 25.6811 30.0203 26.1032 31.0023 26.5941C31.6536 26.9198 31.9175 27.7117 31.5919 28.3629C31.2663 29.0141 30.4744 29.2781 29.8231 28.9525C23.5607 25.8213 16.0833 25.8212 9.82064 28.9525C9.16832 29.2787 8.37695 29.013 8.05193 28.3629C7.7263 27.7117 7.99023 26.9198 8.6415 26.5941C9.26719 26.2812 9.90396 25.9969 10.5494 25.7399V14.502C10.5494 12.3211 12.3237 10.5469 14.5045 10.5469H15.8229V6.5918C15.8229 5.86371 16.4131 5.27344 17.1412 5.27344H19.7779C20.506 5.27344 21.0963 5.86371 21.0963 6.5918C21.0963 7.31988 20.506 7.91016 19.7779 7.91016H18.4596V10.5469H22.4147C23.1416 10.5469 23.733 9.95546 23.733 9.22852V3.95508C23.733 3.22813 23.1416 2.63672 22.4147 2.63672H10.7715C10.2817 2.63672 9.83479 2.89011 9.60514 3.29792C5.04792 11.3945 2.63919 20.6155 2.63919 29.9644V34.8712H2.63927Z"
										fill="inherit" stroke="none" />
                  </svg> Exercise
						</a></li>
						<li class="nav-item"><a class="nav-link" href="food"> <svg
									height="20" viewBox="0 0 45 45" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
                    <path
										d="M25.9088 24.3544C24.9422 23.29 23.6708 22.7037 22.3291 22.7037C20.5986 22.7037 19.1479 23.6223 18.3536 24.2553C17.5757 23.6172 16.1488 22.7037 14.3548 22.7037C13.013 22.7037 11.7418 23.2899 10.7751 24.3544C9.84806 25.3752 9.29965 26.7288 9.23083 28.1659C9.16298 29.5859 9.48588 30.818 10.2781 32.1608C11.5099 34.2491 17.2232 37.9986 17.8708 38.4193C18.0163 38.514 18.1831 38.5613 18.3496 38.5613C18.5161 38.5613 18.6827 38.514 18.8282 38.4195C19.4734 38.0006 25.1668 34.2656 26.4063 32.1601C27.1982 30.8148 27.5212 29.583 27.4533 28.1658C27.3843 26.7287 26.8358 25.3752 25.9088 24.3544ZM24.8914 31.2684C24.0922 32.6259 20.2624 35.3527 18.3489 36.6301C15.9423 35.0299 12.5175 32.4978 11.792 31.2677C11.1761 30.2238 10.9353 29.3213 10.9865 28.2499C11.0866 26.1609 12.5976 24.4615 14.3548 24.4615C16.251 24.4615 17.6733 26.0126 17.6853 26.0258C17.8484 26.2093 18.082 26.3152 18.3275 26.3196C18.5706 26.3222 18.8101 26.2244 18.9798 26.0468C18.995 26.0308 20.5137 24.4615 22.3292 24.4615C24.0863 24.4615 25.5974 26.161 25.6975 28.2499C25.7486 29.3189 25.5074 30.2216 24.8914 31.2684Z"
										fill="inherit" stroke="none" />
                    <path
										d="M24.7051 13.6457C24.7018 13.6457 24.6984 13.6457 24.6951 13.6458C23.1 13.6641 20.9044 14.0339 19.2208 14.7036V12.4009C19.7061 12.4569 20.3706 12.5107 21.1317 12.5107C23.1922 12.5107 25.9586 12.1159 27.7782 10.3002C27.7782 10.3002 27.7782 10.3002 27.7782 10.3001C30.9292 7.15549 29.8111 1.17964 29.7618 0.92679C29.6935 0.574891 29.4181 0.299806 29.0661 0.231606C28.8129 0.182653 22.827 -0.93298 19.677 2.21055C19.4556 2.4315 19.2561 2.66677 19.075 2.91268C18.9177 2.67503 18.6482 2.51807 18.3419 2.51807C17.8565 2.51807 17.4631 2.91153 17.4631 3.39693V14.7036C15.7795 14.0338 13.5839 13.6639 11.9888 13.6457C11.9855 13.6457 11.9821 13.6457 11.9788 13.6457C5.37365 13.6457 0 18.9971 0 25.5748C0 28.8768 1.52756 33.7012 3.8011 37.5797C6.606 42.3647 10.018 44.9999 13.4086 44.9999C14.7857 44.9999 16.9959 44.2307 18.3419 43.3399C19.6879 44.2306 21.8982 44.9999 23.2753 44.9999C26.6639 44.9999 30.0752 42.3647 32.8809 37.5798C35.1556 33.7003 36.6839 28.8759 36.6839 25.5748C36.6838 18.9971 31.3102 13.6457 24.7051 13.6457ZM20.9186 3.45476C22.9026 1.47476 26.6587 1.69413 28.1247 1.86929C28.3 3.33348 28.5187 7.0778 26.5366 9.05587C24.5519 11.0363 20.7946 10.8163 19.3292 10.6413C19.2819 10.2523 19.2319 9.70104 19.2208 9.06536V8.55825C19.2508 6.87215 19.5948 4.77579 20.9186 3.45476ZM31.3645 36.6909C28.9232 40.8544 25.9747 43.2423 23.2752 43.2423C22.1049 43.2423 19.7901 42.3598 18.9297 41.5857C18.7627 41.4353 18.5523 41.3602 18.3419 41.3602C18.1315 41.3602 17.9211 41.4353 17.754 41.5857C16.8937 42.3598 14.5788 43.2423 13.4085 43.2423C10.7071 43.2423 7.75802 40.8544 5.31732 36.691C3.18809 33.0587 1.75756 28.5914 1.75756 25.5749C1.75756 19.9681 6.33979 15.4063 11.9733 15.4035C13.623 15.4232 16.0553 15.8902 17.4629 16.6306V18.2694C17.4629 18.7548 17.8564 19.1482 18.3418 19.1482C18.8271 19.1482 19.2206 18.7548 19.2206 18.2694V16.6306C20.6282 15.8902 23.0606 15.4232 24.7102 15.4035C30.3438 15.4063 34.926 19.9681 34.926 25.5749C34.9261 28.5905 33.4947 33.0576 31.3645 36.6909Z"
										fill="inherit" stroke="none" />
                  </svg> Food
						</a></li>
						<li class="nav-item"><a class="nav-link" href="user"> <svg
									height="20" viewBox="0 0 478 512" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
                    <path
										d="M239 288.389C85.163 288.389 0.440002 361.165 0.440002 493.314C0.440002 503.635 8.805 512 19.126 512H458.873C469.194 512 477.559 503.635 477.559 493.314C477.56 361.172 392.837 288.389 239 288.389ZM38.492 474.628C45.842 375.822 113.205 325.762 239 325.762C364.795 325.762 432.159 375.822 439.515 474.628H38.492V474.628Z"
										fill="inherit" stroke="none" />
                    <path
										d="M239 0C168.335 0 115.049 54.358 115.049 126.437C115.049 200.627 170.653 260.977 239 260.977C307.347 260.977 362.951 200.627 362.951 126.443C362.951 54.358 309.665 0 239 0ZM239 223.611C191.257 223.611 152.421 180.022 152.421 126.443C152.421 74.832 188.834 37.372 239 37.372C288.363 37.372 325.579 75.66 325.579 126.443C325.579 180.022 286.743 223.611 239 223.611Z"
										fill="inherit" stroke="none" />
                  </svg> User
						</a></li>
						<li class="nav-item"><a class="nav-link active" href="imc">
								<svg height="20" viewBox="0 0 45 45" fill="currentColor"
									xmlns="http://www.w3.org/2000/svg">
                    <path
										d="M41.25 0H3.75003C1.67994 0.00246094 0.00246094 1.67994 0 3.75003V41.2501C0.00246094 43.3201 1.67994 44.9975 3.75003 45H41.2501C43.3201 44.9975 44.9976 43.3201 45.0001 41.25V3.75003C44.9975 1.67994 43.3201 0.00246094 41.25 0ZM43.5 41.25C43.4987 42.492 42.492 43.4987 41.25 43.5H3.75003C2.50796 43.4987 1.50135 42.492 1.50003 41.25V3.75003C1.50135 2.50796 2.50796 1.50135 3.75003 1.50003H41.2501C42.4921 1.50135 43.4987 2.50796 43.5001 3.75003V41.25H43.5Z"
										fill="inherit" stroke="none" />
                    <path
										d="M39.7501 2.99998H36C35.172 3.00095 34.501 3.67191 34.5 4.50001V13.5C34.4996 13.9141 34.1641 14.2496 33.75 14.25H11.25C10.836 14.2495 10.5004 13.914 10.5001 13.5V4.50001C10.4991 3.672 9.82813 3.00095 9.00003 2.99998H5.25C4.00793 3.0013 3.00132 4.00791 3 5.24998V39.75C3.00132 40.992 4.00793 41.9986 5.25 42H39.75C40.992 41.9986 41.9987 40.992 42 39.75V5.24998C41.9987 4.00791 40.9921 3.00139 39.7501 2.99998ZM40.5 39.75C40.4998 40.1642 40.1641 40.4997 39.7501 40.5H5.25C4.83595 40.4996 4.50038 40.164 4.50003 39.75V5.24998C4.50047 4.83593 4.83595 4.50037 5.25 4.50001H9.00003V13.5C9.00135 14.7421 10.008 15.7487 11.25 15.75H33.75C34.9921 15.7487 35.9987 14.7421 36 13.5V4.50001H39.7501C40.1642 4.50028 40.4998 4.83593 40.5 5.24998V39.75Z"
										fill="inherit" stroke="none" />
                    <path
										d="M12.0569 12.2821C12.1073 12.3628 12.1593 12.4423 12.2131 12.5207C12.3534 12.667 12.5472 12.7498 12.7499 12.75H22.4191C22.4513 12.76 22.4846 12.7659 22.5182 12.7675C22.5538 12.7663 22.5892 12.7603 22.6233 12.75H32.2499H32.2501H32.2504C32.2563 12.75 32.2622 12.7464 32.2682 12.7463C32.3631 12.7449 32.4567 12.7257 32.5444 12.6894L32.5456 12.6891C32.5583 12.6837 32.566 12.6726 32.5782 12.6666C32.6546 12.631 32.7245 12.5828 32.7848 12.5239C32.8392 12.445 32.8918 12.365 32.9428 12.2839C32.9694 12.2116 32.9847 12.1356 32.9882 12.0587C32.9899 12.0382 33.0001 12.0207 33.0001 11.9999V3.75004C33.0002 3.55115 32.9212 3.36034 32.7804 3.21962C32.6398 3.079 32.449 2.99998 32.25 2.99998H12.75C12.5511 2.9999 12.3603 3.07891 12.2196 3.21962C12.079 3.36025 11.9999 3.55106 11.9999 3.75004V11.9958V12.0001C12.0034 12.0229 12.0079 12.0456 12.0136 12.068C12.0175 12.1411 12.0321 12.2133 12.0569 12.2821ZM22.8069 11.25C22.2548 10.7007 20.7817 9.22106 20.7814 9.22044C20.4889 8.92698 20.0139 8.92619 19.7204 9.2186C19.427 9.51101 19.4262 9.98606 19.7186 10.2795C20.0995 10.662 20.4091 10.9721 20.688 11.25H14.0814C15.1277 9.83629 17.5936 7.49999 22.5 7.49999C27.4077 7.49999 29.8735 9.83744 30.919 11.25H22.8069ZM13.5 4.50001H31.5V9.6069C30.0212 7.97811 27.255 6.00004 22.5 6.00004C17.7449 6.00004 14.9788 7.9782 13.5 9.60699V4.50001Z"
										fill="inherit" stroke="none" />
                    <path
										d="M12 30.75H8.25006C7.00799 30.7513 6.00138 31.758 6.00006 33V36.7501C6.00138 37.9921 7.00799 38.9987 8.25006 39.0001H12.0001C13.2422 38.9987 14.2488 37.9921 14.2501 36.7501V33C14.2487 31.758 13.2421 30.7513 12 30.75ZM12.7501 36.75C12.7496 37.164 12.4141 37.4996 12.0001 37.4999H8.25006C7.83601 37.4995 7.50044 37.164 7.50009 36.75V32.9999C7.50053 32.5859 7.83601 32.2503 8.25006 32.25H12.0001C12.4141 32.2504 12.7497 32.5859 12.7501 32.9999V36.75Z"
										fill="inherit" stroke="none" />
                    <path
										d="M36.75 30.75H32.9999C31.7579 30.7513 30.7513 31.758 30.7499 33V36.7501C30.7513 37.9921 31.7579 38.9987 32.9999 39.0001H36.75C37.992 38.9987 38.9986 37.9921 39 36.7501V33C38.9986 31.758 37.992 30.7513 36.75 30.75ZM37.5 36.75C37.4998 37.164 37.1641 37.4997 36.7501 37.4999H33C32.586 37.4995 32.2504 37.164 32.2501 36.75V32.9999C32.2505 32.5859 32.586 32.2503 33 32.25H36.7501C37.1641 32.2502 37.4998 32.5859 37.5 32.9999V36.75Z"
										fill="inherit" stroke="none" />
                  </svg> BMI
						</a></li>
					</ul>
				</div>
			</nav>

			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">BMI</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group mr-3">
							<button type="button" class="btn btn-sm btn-outline-secondary">
								Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">
								Export</button>
							<button type="button" data-toggle="modal" data-target="#addModal"
								class="btn btn-sm btn-outline-secondary">Add</button>
						</div>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Date</th>
							<th scope="col">Height (m)</th>
							<th scope="col">Weight (kg)</th>
							<th scope="col">BMI</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<WeightHeightBean> imcs = (List<WeightHeightBean>) request.getAttribute("imcs");
						for (WeightHeightBean imc : imcs) {
						%>
						<tr>
							<td scope="row"><%=imc.getId()%></td>
							<td><%=imc.getCreatedAt()%></td>
							<td><%=imc.getHeight()%></td>
							<td><%=imc.getWeight()%></td>
							<td><%=imc.getBmiClassification()%> - <%=imc.getBmi()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</main>
			<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
				aria-labelledby="addModal" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form class="needs-validation form-signin" novalidate>
								<div class="mb-2">
									<label for="input-height">Height</label> <input type="text"
										class="form-control" name="user" id="input-height" required />
									<div class="invalid-feedback">Height required</div>
								</div>
								<div class="mb-2">
									<label for="input-weight">Weight</label> <input type="text"
										class="form-control" name="user" id="input-weight" required />
									<div class="invalid-feedback">Weight required</div>
								</div>
								<div class="modal-footer">
									<button data-dismiss="modal" type="submit" class="btn">
										Save</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script type="text/javascript" src="../../js/icons.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>
