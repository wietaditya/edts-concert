INSERT INTO public.master_concert
(id, additional_info, description, image_url, info, "location", location_url, schedule, status, ticket_purchase_end, ticket_purchase_start, title)
VALUES(1, 'add info', 'desc test', 'https://i.ytimg.com/vi/m7Rtrapcruo/hqdefault.jpg', 'info 123', 'Singapore National Stadium', 'https://maps.app.goo.gl/yaYNwhnSerZH7uAE6', '2024-03-28 00:00:00.000', 'AVAILABLE', '2024-03-24 10:00:00.000', '2024-03-24 10:20:00.000', 'RHCP')
ON CONFLICT DO NOTHING;
INSERT INTO public.master_concert
(id, additional_info, description, image_url, info, "location", location_url, schedule, status, ticket_purchase_end, ticket_purchase_start, title)
VALUES(2, 'add info', 'desc test 2', 'https://cdn.idntimes.com/content-images/post/20221209/318466927-822973662294461-6495430579961785917-n-55f88ca31bd4cc118b2520e6a147b124.jpg', 'info 123', 'Beach City International Stadium Ancol', 'https://maps.app.goo.gl/xSDaizsYGs4ohAaw8', '2024-03-28 00:00:00.000', 'AVAILABLE', '2024-03-24 10:00:00.000', '2024-03-24 10:20:00.000', 'Arctic Monkeys')
ON CONFLICT DO NOTHING;

INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(1, 'additional info package', 'desc package', 'ticket', 'info package', 'VIP BLACK', 1000000.0, 1000)
ON CONFLICT DO NOTHING;
INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(2, 'additional info package', 'desc package', 'ticket', 'info package', 'BLACK', 750000.0, 5000)
ON CONFLICT DO NOTHING;
INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(3, 'additional info package', 'desc package', 'ticket', 'info package', 'VIP BLACK', 400000.0, 10000)
ON CONFLICT DO NOTHING;
INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(4, 'additional info package', 'desc package', 'ticket', 'info package', 'VIP', 1000000.0, 100)
ON CONFLICT DO NOTHING;
INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(5, 'additional info package', 'desc package', 'ticket', 'info package', 'Festival 1', 750000.0, 500)
ON CONFLICT DO NOTHING;
INSERT INTO public.master_packages
(id, additional_info, description, facility, info, package_name, price, quota)
VALUES(6, 'additional info package', 'desc package', 'ticket', 'info package', 'Festival 2', 400000.0, 1000)
ON CONFLICT DO NOTHING;

INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(1, 1)
ON CONFLICT DO NOTHING;
INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(1, 2)
ON CONFLICT DO NOTHING;
INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(1, 3)
ON CONFLICT DO NOTHING;
INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(2, 4)
ON CONFLICT DO NOTHING;
INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(2, 5)
ON CONFLICT DO NOTHING;
INSERT INTO public.concert_packages
(concert_id, package_id)
VALUES(2, 6)
ON CONFLICT DO NOTHING;

INSERT INTO public.master_user
(id, email, full_name, username)
VALUES(1, 'bc.wiwiet@gmail.com', 'Wiwiet Aditya', 'aditya001')
ON CONFLICT DO NOTHING;
INSERT INTO public.master_user
(id, email, full_name, username)
VALUES(2, 'rosy1877@gmail.com', 'Rosy Lestari', 'rosy123')
ON CONFLICT DO NOTHING;